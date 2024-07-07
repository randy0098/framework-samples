package com.framework.backend.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
  private static final Logger logger = LoggerFactory.getLogger(MyMetaObjectHandler.class);

  @Override
  /** 创建记录时还需要同时修改更新相关的字段信息 */
  public void insertFill(MetaObject metaObject) {
    logger.debug("start insert fill ....");
    // 注意这里的fieldName是实体字段名称，而不是数据库字段名称！
    this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
    this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
    // 以下为测试数据，实际使用时改为当前登录用户信息
    this.strictInsertFill(metaObject, "createUser", String.class, "randy");
    this.strictInsertFill(metaObject, "updateUser", String.class, "randy");
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    logger.debug("start update fill ....");
    this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    // 以下为测试数据，实际使用时改为当前登录用户信息
    this.strictInsertFill(metaObject, "updateUser", String.class, "leon");
  }

  /**
   * 默认填充策略为如果属性有值则不覆盖,现在改为每次都覆盖更新
   *
   * @param metaObject
   * @param fieldName
   * @param fieldVal
   * @return
   */
  @Override
  public MetaObjectHandler fillStrategy(MetaObject metaObject, String fieldName, Object fieldVal) {
    setFieldValByName(fieldName, fieldVal, metaObject);
    return this;
  }
}
