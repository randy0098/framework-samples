package com.framework.backend.common.exception;

import com.framework.backend.common.result.MyResult;
import com.framework.backend.enums.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/** 全局异常处理 */
@ControllerAdvice
public class GlobalExceptionHandler {
  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  /**
   * 系统中的自定义业务异常
   *
   * @param request
   * @param response
   * @param businessException
   * @return
   */
  @ExceptionHandler(BusinessException.class)
  @ResponseBody
  public Object businessException(
      HttpServletRequest request,
      HttpServletResponse response,
      BusinessException businessException) {
    // 设置HTTP状态码
    response.setStatus(ResultCode.FAIL.getCode());
    // 设置前端返回值
    MyResult result = new MyResult();
    // 当ResultCode存在时按它返回异常信息
    ResultCode resultCode = businessException.getResultCode();
    if (resultCode != null) {
      result.setCode(resultCode.getCode());
      result.setMessage(resultCode.getMessage());
    }
    // 当ResultCode不存在时就按message异常信息
    else {
      result.setCode(ResultCode.FAIL.getCode());
      result.setMessage(businessException.getMessage());
    }
    return result;
  }

  /**
   * 系统中的所有Exception异常
   *
   * @param request
   * @param response
   * @param exception
   * @return
   */
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public Object commonException(
      HttpServletRequest request, HttpServletResponse response, Exception exception) {
    response.setStatus(ResultCode.FAIL.getCode());
    MyResult result = new MyResult();
    result.setCode(ResultCode.FAIL.getCode());
    result.setMessage("系统异常");
    String str = getExceptionStackTrace(exception);
    result.setData(str);
    return result;
  }

  private String getExceptionStackTrace(Exception exception) {
    StringWriter sw = new StringWriter();
    exception.printStackTrace(new PrintWriter(sw, true));
    String str = sw.toString();
    logger.error(str);
    return str;
  }
}
