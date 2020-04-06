package org.huifer.springcloud.servicea.eception.handler;

import com.alibaba.fastjson.JSONException;
import org.huifer.springcloud.servicea.model.enums.ResultCode;
import org.huifer.springcloud.servicea.model.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  /**
   * 文字转换异常
   *
   * @param e JSONException
   * @return 状态码 文字信息GlobalExceptionHandler
   */
  @ExceptionHandler(JSONException.class)
  @ResponseBody
  public Object customHandler(JSONException e) {
    LOGGER.error(e.getMessage(), e);
    return ResultVO.failed(
        ResultCode.PARAM_ERROR.getCode(), "请按照规定输入内容,错误内容为:" + e.getMessage());
  }

  /**
   * 数字转换异常
   *
   * @param e JSONException
   * @return 状态码 文字信息GlobalExceptionHandler
   */
  @ExceptionHandler(NumberFormatException.class)
  @ResponseBody
  public Object customHandler(NumberFormatException e) {
    LOGGER.error(e.getMessage(), e);
    return ResultVO.failed(
        ResultCode.PARAM_ERROR.getCode(), "请勿在要求输入数字的内容输入文字,错误内容为:" + e.getMessage());
  }

  /**
   * 校验参数转换异常
   *
   * @param e JSONException
   * @return 状态码 文字信息GlobalExceptionHandler
   */
  @ExceptionHandler(BindException.class)
  @ResponseBody
  public Object customHandler(BindException e) {
    LOGGER.error(e.getMessage(), e);
    return ResultVO.failed(
        ResultCode.PARAM_ERROR.getCode(), "请按照接口字段要求输入,错误内容为:" + e.getMessage());
  }

  /**
   * 断言退出,未通过业务判断的断言异常退出
   *
   * @param e JSONException
   * @return 状态码 文字信息GlobalExceptionHandler
   */
  @ExceptionHandler(IllegalStateException.class)
  @ResponseBody
  public Object customHandler(IllegalStateException e) {
    LOGGER.error(e.getMessage(), e);
    LOGGER.info("校验未通过,退出执行方法");
    return ResultVO.failed(ResultCode.ASSERT_ERROR.getCode(), e.getMessage());
  }
}
