package com.framework.backend.test.mapper.sql;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

public class UserSqlProvider {
  public String listTest(@Param(Constants.WRAPPER) Wrapper wrapper) {
    String sql =
        "SELECT A.*,C.NAME AS orgName FROM SECURITY_USER AS A INNER JOIN SECURITY_ORGANIZATION_USER_REL AS B ON A.ID = B.USER_ID INNER JOIN SECURITY_ORGANIZATION AS C ON B.ORG_ID = C.ID ";
    sql += " ${ew.customSqlSegment} ";
    return sql;
  }

  public String pageListTest(@Param(Constants.WRAPPER) Wrapper wrapper) {
    String sql =
        "SELECT A.*,C.NAME AS orgName FROM SECURITY_USER AS A INNER JOIN SECURITY_ORGANIZATION_USER_REL AS B ON A.ID = B.USER_ID INNER JOIN SECURITY_ORGANIZATION AS C ON B.ORG_ID = C.ID ";
    sql += " ${ew.customSqlSegment} ";
    return sql;
  }
}
