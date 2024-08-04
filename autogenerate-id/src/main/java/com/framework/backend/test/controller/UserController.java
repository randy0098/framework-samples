package com.framework.backend.test.controller;

import com.framework.backend.common.MyBaseController;
import com.framework.backend.test.entity.User;
import com.framework.backend.test.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/user")
public class UserController extends MyBaseController<UserService, User> {
  /**
   * 创建用户信息
   *
   * @param user
   * @return
   */
  @PostMapping(value = "/create")
  public boolean create(@RequestBody User user) {
    return myBaseService.save(user);
  }
}
