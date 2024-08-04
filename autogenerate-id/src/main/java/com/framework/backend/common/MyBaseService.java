package com.framework.backend.common;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface MyBaseService<T> extends IService<T> {
  default MyPage myPage(MyPage page, Wrapper<T> queryWrapper) {
    MyPage myPage = getBaseMapper().selectPage(page, queryWrapper);
    myPage.setCurrentPage(myPage.getCurrent());
    myPage.setPageSize(myPage.getSize());
    return myPage;
  }

  MyPage<T> customPagingQuery(List<SqlParam> sqlParams, long currentPage, long pageSize);

  List<T> customQuery(List<SqlParam> sqlParams);
}
