package com.framework.backend.common.result;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {
  @Autowired ObjectMapper objectMapper;

  /**
   * 判断是否要执行beforeBodyWrite方法，true为执行，false不执行
   *
   * @param methodParameter
   * @param aClass
   * @return
   */
  @Override
  public boolean supports(MethodParameter methodParameter, Class aClass) {
    boolean result = false;
    // 如果方法上有自动封装返回值的注解，就以其为准
    ResponseResult methodAnnotation = methodParameter.getMethodAnnotation(ResponseResult.class);
    if (methodAnnotation != null) {
      result = methodAnnotation.autoPackage();
    } else {
      // 如果方法上没自动封装返回值的注解，而类上有，就以其为准
      ResponseResult classAnnotation =
          methodParameter.getDeclaringClass().getAnnotation(ResponseResult.class);
      if (classAnnotation != null) {
        result = classAnnotation.autoPackage();
      }
    }
    return result;
  }

  /**
   * 对返回结果过滤字段和统一格式化
   *
   * @param body
   * @param methodParameter
   * @param mediaType
   * @param aClass
   * @param serverHttpRequest
   * @param serverHttpResponse
   * @return
   */
  @SneakyThrows
  @Override
  public Object beforeBodyWrite(
      Object body,
      MethodParameter methodParameter,
      MediaType mediaType,
      Class aClass,
      ServerHttpRequest serverHttpRequest,
      ServerHttpResponse serverHttpResponse) {
    // 当controller方法直接返回字符串结果时，会报String强转错误，所以这里需要手工对String返回值转json进行处理。
    boolean isString = body instanceof String;

    // 返回结果统一格式化
    body = new MyResult().success(body);

    if (isString) {
      body = objectMapper.writeValueAsString(body);
    }

    return body;
  }
}
