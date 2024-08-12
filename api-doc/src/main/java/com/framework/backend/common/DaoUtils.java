package com.framework.backend.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.framework.backend.enums.SqlOperator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Slf4j
public class DaoUtils {
  public static QueryWrapper generateQueryWrapper(List<SqlParam> sqlParams) {
    QueryWrapper queryWrapper = new QueryWrapper();
    for (int i = 0; i < sqlParams.size(); i++) {
      SqlParam sqlParam = sqlParams.get(i);
      SqlOperator sqlOperator = sqlParam.getSqlOperator();
      SqlOperator linkOperator = sqlParam.getLinkOperator();
      Object value = sqlParam.getValue();

      // 查询条件间以“或”连接
      if (linkOperator == SqlOperator.OR) {
        queryWrapper.or();
      }

      // 否则查询条件间默认以”且“连接
      switch (sqlOperator) {
        case LIKE:
          // 模糊匹配
          if (checkValue(value)) {
            queryWrapper.like(sqlParam.getColumnName(), value);
          }
          break;
        case EQ:
          // 等于
          if (checkValue(value)) {
            queryWrapper.eq(sqlParam.getColumnName(), value);
          }
          break;
        case GE:
          // 大于等于
          if (checkValue(value)) {
            queryWrapper.ge(sqlParam.getColumnName(), value);
          }
          break;
        case GT:
          // 大于
          if (checkValue(value)) {
            queryWrapper.gt(sqlParam.getColumnName(), value);
          }
          break;
        case LE:
          // 小于等于
          if (checkValue(value)) {
            queryWrapper.le(sqlParam.getColumnName(), value);
          }
          break;
        case LT:
          // 小于
          if (checkValue(value)) {
            queryWrapper.lt(sqlParam.getColumnName(), value);
          }
          break;
        case NE:
          // 不等于
          if (checkValue(value)) {
            queryWrapper.ne(sqlParam.getColumnName(), value);
          }
          break;
        case ORDER_BY_ASC:
          // 升序排序
          queryWrapper.orderByAsc(sqlParam.getColumnName());
          break;
        case ORDER_BY_DESC:
          // 降序排序
          queryWrapper.orderByDesc(sqlParam.getColumnName());
          break;
        case GROUP_BY:
          // 分组排序
          queryWrapper.groupBy(sqlParam.getColumnName());
          break;
        default:
          log.error("QueryWrapper排序规则不支持:" + sqlOperator);
      }
    }
    return queryWrapper;
  }

  /**
   * 判断查询条件的值是否为空， 当查询条件的值为空时就不需要执行对应的QueryWrapper设置方法。
   *
   * @param value
   * @return
   */
  private static boolean checkValue(Object value) {
    boolean result = (null != value) && (StringUtils.isNotBlank(value.toString()));
    return result;
  }
}
