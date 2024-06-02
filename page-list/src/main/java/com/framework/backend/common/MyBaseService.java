package com.framework.backend.common;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

public interface MyBaseService<T> extends IService<T> {
  default MyPage myPage(MyPage page, Wrapper<T> queryWrapper) {
    MyPage myPage = getBaseMapper().selectPage(page, queryWrapper);
    myPage.setCurrentPage(myPage.getCurrent());
    myPage.setPageSize(myPage.getSize());
    return myPage;
  }
}
