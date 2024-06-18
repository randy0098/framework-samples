package com.framework.backend.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.framework.backend.common.DaoUtils;
import com.framework.backend.common.MyBaseController;
import com.framework.backend.common.MyPage;
import com.framework.backend.common.SqlParam;
import com.framework.backend.enums.SqlOperator;
import com.framework.backend.test.entity.User;
import com.framework.backend.test.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test/user")
public class UserController extends MyBaseController<UserService, User> {
  /**
   * 根据条件查询所有记录
   *
   * @param user
   * @return
   */
  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public List<User> list(@RequestBody(required = false) User user) {
    List<SqlParam> sqlParams = new ArrayList<>();
    // A:用户表；B:用户组织关联表；C:组织表
    SqlParam sqlParam1 = new SqlParam("C.NAME", user.getOrgName(), SqlOperator.EQ);
    SqlParam sqlParam2 = new SqlParam("A.REAL_NAME", user.getRealName(), SqlOperator.LIKE);
    sqlParams.add(sqlParam1);
    sqlParams.add(sqlParam2);
    QueryWrapper queryWrapper = DaoUtils.generateQueryWrapper(sqlParams);
    List<User> result = myBaseService.listTest(queryWrapper);
    return result;
  }

  /**
   * 根据条件分页查询记录
   *
   * @param user
   * @return
   */
  @RequestMapping(value = "/pageList", method = RequestMethod.POST)
  public MyPage<User> pageList(@RequestBody User user) {
    List<SqlParam> sqlParams = new ArrayList<>();
    // A:用户表；B:用户组织关联表；C:组织表
    SqlParam sqlParam1 = new SqlParam("C.NAME", user.getOrgName(), SqlOperator.EQ);
    SqlParam sqlParam2 = new SqlParam("A.REAL_NAME", user.getRealName(), SqlOperator.LIKE);
    sqlParams.add(sqlParam1);
    sqlParams.add(sqlParam2);
    QueryWrapper queryWrapper = DaoUtils.generateQueryWrapper(sqlParams);
    MyPage<User> page = new MyPage<>(user.getCurrentPage(), user.getPageSize());
    MyPage<User> result = myBaseService.pageListTest(page, queryWrapper);
    return result;
  }
}
