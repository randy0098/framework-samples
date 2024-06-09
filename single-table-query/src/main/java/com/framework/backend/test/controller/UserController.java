package com.framework.backend.test.controller;

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
    SqlParam sqlParam1 = new SqlParam("ACCOUNT", user.getAccount(), SqlOperator.EQ);
    SqlParam sqlParam2 = new SqlParam("REAL_NAME", user.getRealName(), SqlOperator.LIKE);
    sqlParams.add(sqlParam1);
    sqlParams.add(sqlParam2);

    SqlParam sortParam = new SqlParam("SORT", SqlOperator.ORDER_BY_ASC);
    sqlParams.add(sortParam);

    List<User> result = myBaseService.customQuery(sqlParams);
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
    SqlParam sqlParam1 = new SqlParam("ACCOUNT", user.getAccount(), SqlOperator.EQ);
    // SqlParam2第三个参数表示“ACCOUNT”和”REAL_NAME“这两个查询条件是”OR”关系，默认是“AND”关系
    SqlParam sqlParam2 =
        new SqlParam("REAL_NAME", user.getRealName(), SqlOperator.LIKE, SqlOperator.OR);
    sqlParams.add(sqlParam1);
    sqlParams.add(sqlParam2);

    SqlParam sortParam = new SqlParam("SORT", SqlOperator.ORDER_BY_ASC);
    sqlParams.add(sortParam);

    MyPage<User> result =
        myBaseService.customPagingQuery(sqlParams, user.getCurrentPage(), user.getPageSize());
    return result;
  }
}
