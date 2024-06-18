package com.framework.backend.test.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.framework.backend.common.MyBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("SECURITY_ORGANIZATION")
public class Organization extends MyBaseEntity {
  private static final long serialVersionUID = 1L;

  @TableField(value = "NAME")
  private String name;
}
