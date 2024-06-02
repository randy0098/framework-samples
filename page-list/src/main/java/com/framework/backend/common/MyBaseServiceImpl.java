package com.framework.backend.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class MyBaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T>
    implements MyBaseService<T> {}
