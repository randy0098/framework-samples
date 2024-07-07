package com.framework.backend.test.service.impl;

import com.framework.backend.common.MyBaseServiceImpl;
import com.framework.backend.test.entity.User;
import com.framework.backend.test.mapper.UserMapper;
import com.framework.backend.test.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends MyBaseServiceImpl<UserMapper, User> implements UserService {}
