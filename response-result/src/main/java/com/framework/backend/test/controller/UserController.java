package com.framework.backend.test.controller;

import com.framework.backend.common.result.ResponseResult;
import com.framework.backend.test.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test/user")
@ResponseResult
public class UserController {
  /**
   * 自动封装单个对象的返回值
   *
   * @return
   */
  @GetMapping(value = "/test1")
  public User test1() {
    User user = new User();
    user.setRealName("Randy");
    user.setGender("male");
    return user;
  }

  /**
   * 自动封装多个对象集合的返回值
   *
   * @return
   */
  @GetMapping(value = "/test2")
  public List<User> test2() {
    User user1 = new User();
    user1.setRealName("Randy");
    user1.setGender("male");

    User user2 = new User();
    user2.setRealName("Lucy");
    user2.setGender("female");

    List<User> result = new ArrayList();
    result.add(user1);
    result.add(user2);
    return result;
  }

  /**
   * 不自动封装返回值
   *
   * @return
   */
  @ResponseResult(autoPackage = false)
  @GetMapping(value = "/test3")
  public List<User> test3() {
    User user1 = new User();
    user1.setRealName("Randy");
    user1.setGender("male");

    User user2 = new User();
    user2.setRealName("Lucy");
    user2.setGender("female");

    List<User> result = new ArrayList();
    result.add(user1);
    result.add(user2);
    return result;
  }

  /**
   * 返回字符串类型的结果值
   *
   * @return
   */
  @GetMapping(value = "/test4")
  public String test4() {
    return "success";
  }
}
