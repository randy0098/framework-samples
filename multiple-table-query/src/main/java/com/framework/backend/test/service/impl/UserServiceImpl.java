package com.framework.backend.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.framework.backend.common.MyBaseServiceImpl;
import com.framework.backend.common.MyPage;
import com.framework.backend.test.entity.User;
import com.framework.backend.test.mapper.UserMapper;
import com.framework.backend.test.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends MyBaseServiceImpl<UserMapper, User> implements UserService {
  @Override
  public List<User> listTest(Wrapper wrapper) {
    List<User> result = baseMapper.listTest(wrapper);
    return result;
  }

  @Override
  public MyPage<User> pageListTest(MyPage<User> page, Wrapper wrapper) {
    MyPage<User> result = baseMapper.pageListTest(page, wrapper);
    return result;
  }
}
