package com.framework.backend.test.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.framework.backend.common.MyBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("SECURITY_ORGANIZATION_USER_REL")
public class OrganizationUserRel extends MyBaseEntity {
  private static final long serialVersionUID = 1L;

  @TableField("ORG_ID")
  private String orgId;

  @TableField("USER_ID")
  private String userId;

  @TableField("RELATION_TYPE")
  private String relationType;
}
