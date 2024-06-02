package com.framework.backend.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode()
public class MyBaseEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @TableId(value = "ID")
  protected String id;

  @TableField(exist = false)
  protected long pageSize;

  @TableField(exist = false)
  protected long currentPage;
}
