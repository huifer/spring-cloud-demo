package org.huifer.springcloud.servicea.eception.handler;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.huifer.springcloud.servicea.eception.ServiceException;
import org.huifer.springcloud.servicea.model.enums.ResultCode;
import org.huifer.springcloud.servicea.model.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class SiteExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(SiteExceptionHandler.class);
  @Autowired
  private HttpServletRequest httpServletRequest;

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public ResultVO doExceptionHandler(Exception e) {
    Integer code;
    String msg;
    if (e instanceof ServiceException) {
      ServiceException se = (ServiceException) e;
      code = ResultCode.ERROR.getCode();
      msg = se.getErrorMessage();

      if (StringUtils.isNotBlank(se.getCode())) {
        if (StringUtils.isNumeric(se.getCode())) {
          code = NumberUtils.toInt(se.getCode());
        } else {
          msg = "[" + se.getCode() + "] " + msg;
        }
      }
    } else if (e instanceof MethodArgumentNotValidException) {
      code = ResultCode.PARAM_ERROR.getCode();
      MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
      msg = StringUtils
          .defaultIfBlank(ex.getBindingResult().getFieldError().getDefaultMessage(),
              ResultCode.PARAM_ERROR.getMessage() + ":" + ex.getBindingResult()
                  .getFieldError().getField());
    } else if (e instanceof MaxUploadSizeExceededException) {
      code = ResultCode.MAX_UPLOAD_SIZE.getCode();
      msg = ResultCode.MAX_UPLOAD_SIZE.getMessage();
    } else if (e instanceof NoHandlerFoundException) {
      code = ResultCode.REMOTE_SERVICE_ERROR.getCode();
      msg = StringUtils
          .defaultIfBlank(e.getMessage(), ResultCode.REMOTE_SERVICE_ERROR.getMessage());
    } else {
      code = ResultCode.ERROR.getCode();
      msg = StringUtils.defaultIfBlank(e.getMessage(), ResultCode.ERROR.getMessage());
    }
    LOG.error(
        "url=" + (httpServletRequest != null ? httpServletRequest.getRequestURI() : "内部调用")
            + ", code=" + code + ", msg=" + msg, e);

    return new ResultVO(code, msg);
  }
}