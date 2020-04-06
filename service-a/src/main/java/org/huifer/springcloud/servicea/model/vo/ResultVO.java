package org.huifer.springcloud.servicea.model.vo;


import org.huifer.springcloud.servicea.model.enums.ResultCode;

import java.io.Serializable;

/**
 * rest接口返回对象
 *
 * @param <T>
 */
public class ResultVO<T> implements Serializable {

  private static final long serialVersionUID = 1756678534165418464L;
  private Integer code;
  private String message;
  private T data;

  public ResultVO() {
    this(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMessage());
  }

  public ResultVO(Integer code, String message) {
    this(code, message, null);
  }

  public ResultVO(Integer code, String message, T data) {
    super();
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public static <T> ResultVO<T> success() {
    return ResultCode.SUCCESS.toResponse();
  }

  public static <T> ResultVO<T> success(T result) {
    return ResultCode.SUCCESS.toResponse(result);
  }

  public static <T> ResultVO<T> failed() {
    return ResultCode.ERROR.toResponse();
  }

  public static <T> ResultVO<T> failed(String message) {
    return new ResultVO<T>(ResultCode.ERROR.getCode(), message, null);
  }

  public static <T> ResultVO<T> failed(Integer code, String message) {
    return new ResultVO<T>(code, message, null);
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
