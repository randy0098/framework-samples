package com.framework.backend.test.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.framework.backend.common.MyBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("SECURITY_USER")
public class User extends MyBaseEntity {
  private static final long serialVersionUID = 1L;

  @TableField(value = "ACCOUNT")
  private String account;

  @TableField("REAL_NAME")
  private String realName;
}
