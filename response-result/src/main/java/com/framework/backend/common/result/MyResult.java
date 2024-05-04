package com.framework.backend.common.result;

import com.framework.backend.enums.ResultCode;

import java.io.Serializable;

public class MyResult<T> implements Serializable {
  private Integer code;
  private String message;
  private T data;

  public MyResult() {}

  public MyResult(Integer code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public MyResult(ResultCode resultCode) {
    this.code = resultCode.getCode();
    this.message = resultCode.getMessage();
  }

  public MyResult<T> success(T data) {
    MyResult<T> result = new MyResult();
    result.setData(data);
    result.setCode(ResultCode.SUCCESS.getCode());
    result.setMessage(ResultCode.SUCCESS.getMessage());
    return result;
  }

  public MyResult<T> fail(ResultCode resultCode) {
    MyResult<T> result = new MyResult();
    result.setCode(resultCode.getCode());
    result.setMessage(resultCode.getMessage());
    return result;
  }

  public MyResult<T> fail(ResultCode resultCode, T data) {
    MyResult result = new MyResult();
    result.setCode(resultCode.getCode());
    result.setMessage(resultCode.getMessage());
    result.setData(data);
    return result;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
