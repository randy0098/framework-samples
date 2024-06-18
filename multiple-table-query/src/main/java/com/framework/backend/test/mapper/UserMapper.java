package com.framework.backend.test.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.framework.backend.common.MyBaseMapper;
import com.framework.backend.common.MyPage;
import com.framework.backend.test.entity.User;
import com.framework.backend.test.mapper.sql.UserSqlProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface UserMapper extends MyBaseMapper<User> {
  @SelectProvider(type = UserSqlProvider.class, method = "listTest")
  List<User> listTest(@Param(Constants.WRAPPER) Wrapper wrapper);

  @SelectProvider(type = UserSqlProvider.class, method = "pageListTest")
  MyPage<User> pageListTest(MyPage<User> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
