package com.framework.backend.common.exception;

import com.framework.backend.enums.ResultCode;

/** 自定义异常基类 */
public class MyBaseException extends RuntimeException {
  protected ResultCode resultCode;

  public MyBaseException() {
    super();
  }

  public MyBaseException(String message) {
    super(message);
  }

  public MyBaseException(ResultCode resultCode) {
    super(resultCode.getMessage());
    this.resultCode = resultCode;
  }

  public ResultCode getResultCode() {
    return resultCode;
  }

  public void setResultCode(ResultCode resultCode) {
    this.resultCode = resultCode;
  }
}
