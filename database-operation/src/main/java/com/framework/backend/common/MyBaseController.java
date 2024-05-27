package com.framework.backend.common;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class MyBaseController<S extends MyBaseService<T>, T> {
  @Autowired protected S myBaseService;
}
