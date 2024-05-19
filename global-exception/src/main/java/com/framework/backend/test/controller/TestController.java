package com.framework.backend.test.controller;

import com.framework.backend.common.exception.BusinessException;
import com.framework.backend.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
  @GetMapping(value = "/test1")
  public int test1() {
    int result = 1 / 0;
    return result;
  }

  @GetMapping(value = "/test2")
  public void test2() {
    throw new BusinessException("业务异常1");
  }

  @GetMapping(value = "/test3")
  public void test3() {
    throw new BusinessException(ResultCode.FAIL);
  }
}
