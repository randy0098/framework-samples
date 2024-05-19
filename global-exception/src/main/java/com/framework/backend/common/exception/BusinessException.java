package com.framework.backend.common.exception;

import com.framework.backend.enums.ResultCode;

/** 自定义业务异常 */
public class BusinessException extends MyBaseException {
  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(ResultCode resultCode) {
    super(resultCode);
  }
}
