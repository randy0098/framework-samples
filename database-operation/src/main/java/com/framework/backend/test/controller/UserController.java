package com.framework.backend.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.framework.backend.common.MyBaseController;
import com.framework.backend.test.entity.User;
import com.framework.backend.test.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test/user")
public class UserController extends MyBaseController<UserService, User> {
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public boolean create(@RequestBody User user) throws Exception {
    boolean result = myBaseService.save(user);
    if (result == false) {
      throw new Exception("新增记录失败！");
    }
    return result;
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public boolean update(@RequestBody User user) throws Exception {
    String id = user.getId();
    if (StringUtils.isBlank(id)) {
      throw new Exception("修改记录时id不能为空！");
    }
    boolean result = myBaseService.updateById(user);
    if (result == false) {
      throw new Exception("修改记录失败！");
    }
    return result;
  }

  @RequestMapping(value = "/getOne", method = RequestMethod.POST)
  public User getOne(@RequestBody User user) {
    User result = myBaseService.getOne(new QueryWrapper(user));
    return result;
  }

  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public List<User> list(@RequestBody(required = false) User user) {
    List<User> result = myBaseService.list(new QueryWrapper(user));
    return result;
  }

  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  public boolean delete(@RequestBody User user) throws Exception {
    String id = user.getId();
    if (StringUtils.isBlank(id)) {
      throw new Exception("删除记录时id不能为空！");
    }
    // 为了安全起见，只允许按id进行删除
    boolean result = myBaseService.removeById(user.getId());
    if (result == false) {
      throw new Exception("删除记录失败！");
    }
    return result;
  }
}
