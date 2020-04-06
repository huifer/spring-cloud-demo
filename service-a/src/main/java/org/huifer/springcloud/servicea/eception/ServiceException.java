package org.huifer.springcloud.servicea.eception;

import org.apache.commons.lang3.StringUtils;
import org.huifer.springcloud.servicea.model.enums.ResultCode;

public class ServiceException extends RuntimeException {

  private String code = StringUtils.EMPTY;
  private String errorMessage = StringUtils.EMPTY;

  public ServiceException(String errorMessage) {
    this(StringUtils.EMPTY, errorMessage);
  }

  public ServiceException(ResultCode rc) {
    super();
    this.code = rc.getCode().toString();
    this.errorMessage = rc.getMessage();
  }

  public ServiceException(String code, String errorMessage) {
    super(errorMessage);
    this.code = code;
    this.errorMessage = errorMessage;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}