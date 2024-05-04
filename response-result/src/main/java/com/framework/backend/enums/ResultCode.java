package com.framework.backend.enums;

import org.springframework.http.HttpStatus;

public enum ResultCode {
  SUCCESS(HttpStatus.OK.value(), "成功"),
  FAIL(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统内部错误"),
  UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), "未授权访问"),
  FORBIDDEN(HttpStatus.FORBIDDEN.value(), "禁止访问"),
  LOGIN_FAIL(HttpStatus.INTERNAL_SERVER_ERROR.value(), "用户账号或密码输入错误"),
  CAPTCHA_FAIL(HttpStatus.INTERNAL_SERVER_ERROR.value(), "验证码输入错误"),
  PASSWORD_EXPIRED(HttpStatus.INTERNAL_SERVER_ERROR.value(), "用户密码过期错误"),
  LOGIN_SUCCESS(HttpStatus.OK.value(), "用户登录成功"),
  LOGOUT_SUCCESS(HttpStatus.OK.value(), "用户登出成功"),
  MULTIPLE_LOGIN(HttpStatus.UNAUTHORIZED.value(), "用户重复登录");

  private Integer code;
  private String message;

  ResultCode() {}

  ResultCode(Integer code, String message) {
    this.code = code;
    this.message = message;
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
}
