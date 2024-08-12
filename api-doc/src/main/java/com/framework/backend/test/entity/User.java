package com.framework.backend.test.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.framework.backend.common.MyBaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("SECURITY_USER")
public class User extends MyBaseEntity {
  private static final long serialVersionUID = 1L;

  @Schema(description = "登录名")
  @TableField(value = "ACCOUNT")
  private String account;

  @Schema(description = "姓名")
  @TableField("REAL_NAME")
  private String realName;

  @Schema(description = "排序编号")
  @TableField("SORT")
  private Integer sort;
}
