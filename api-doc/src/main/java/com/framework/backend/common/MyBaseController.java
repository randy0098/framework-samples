package com.framework.backend.common;

import com.framework.backend.common.result.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;

@ResponseResult
public abstract class MyBaseController<S extends MyBaseService<T>, T> {
  @Autowired protected S myBaseService;
}
