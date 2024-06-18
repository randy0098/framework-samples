package com.framework.backend.test.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.framework.backend.common.MyBaseService;
import com.framework.backend.common.MyPage;
import com.framework.backend.test.entity.User;

import java.util.List;

public interface UserService extends MyBaseService<User> {
  List<User> listTest(Wrapper wrapper);

  MyPage<User> pageListTest(MyPage<User> page, Wrapper wrapper);
}
