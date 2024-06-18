package com.framework.backend.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

public class MyBaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T>
    implements MyBaseService<T> {
  @Override
  public MyPage<T> customPagingQuery(List<SqlParam> sqlParams, long currentPage, long pageSize) {
    MyPage<T> page = new MyPage<>(currentPage, pageSize);
    QueryWrapper queryWrapper = DaoUtils.generateQueryWrapper(sqlParams);
    MyPage<T> myPage = this.myPage(page, queryWrapper);
    return myPage;
  }

  @Override
  public List<T> customQuery(List<SqlParam> sqlParams) {
    QueryWrapper queryWrapper = DaoUtils.generateQueryWrapper(sqlParams);
    List<T> result = this.list(queryWrapper);
    return result;
  }
}
