package com.framework.backend.common;

import com.framework.backend.enums.SqlOperator;

public class SqlParam {
  private String columnName;
  private Object value;
  private SqlOperator sqlOperator;
  private SqlOperator linkOperator;

  public SqlParam() {}

  public SqlParam(String columnName, SqlOperator sqlOperator) {
    this.columnName = columnName;
    this.sqlOperator = sqlOperator;
  }

  public SqlParam(String columnName, Object value, SqlOperator sqlOperator) {
    this.columnName = columnName;
    this.value = value;
    this.sqlOperator = sqlOperator;
    this.linkOperator = SqlOperator.AND;
  }

  public SqlParam(
      String columnName, String value, SqlOperator sqlOperator, SqlOperator linkOperator) {
    this.columnName = columnName;
    this.value = value;
    this.sqlOperator = sqlOperator;
    this.linkOperator = linkOperator;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public SqlOperator getSqlOperator() {
    return sqlOperator;
  }

  public void setSqlOperator(SqlOperator sqlOperator) {
    this.sqlOperator = sqlOperator;
  }

  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  public SqlOperator getLinkOperator() {
    return linkOperator;
  }

  public void setLinkOperator(SqlOperator linkOperator) {
    this.linkOperator = linkOperator;
  }
}
