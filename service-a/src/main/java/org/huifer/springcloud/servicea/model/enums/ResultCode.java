package org.huifer.springcloud.servicea.model.enums;


import org.huifer.springcloud.servicea.model.vo.ResultVO;

/**
 * 服务端响应代码枚举类
 */
public enum ResultCode {
  /**
   * 成功
   */
  SUCCESS(0, "成功"),
  /**
   * 请求超时
   */
  TIMEOUT(1, "请求超时"),
  /**
   * 服务器发生错误
   */
  ERROR(2, "服务器发生错误"),
  /**
   * 无效token
   */
  UNAUTH(3, "无效token"),
  /**
   * 缺少权限
   */
  PERMISSION_ERROR(4, "缺少权限"),
  /**
   * 参数错误
   */
  PARAM_ERROR(5, "参数错误"),
  /**
   * 资源不存在
   */
  REMOTE_SERVICE_ERROR(6, "资源不存在"),
  /**
   * 未通过验证 用于断言参数
   */
  ASSERT_ERROR(9, "未通过验证"),
  /**
   * 文件大小超过限制
   */
  MAX_UPLOAD_SIZE(10, "文件大小超过限制");

  /**
   * 编码
   */
  private Integer code;

  /**
   * 消息
   */
  private String message;

  ResultCode(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public static void main(String[] args) {
    ResultCode max_upload_size = ResultCode.valueOf("MAX_UPLOAD_SIZE");
    System.out.println(max_upload_size);
  }

  public static Integer getCodeByName(String name) {
    for (ResultCode resultCode : ResultCode.values()) {
      if (resultCode.name().equals(name)) {
        return resultCode.code;
      }
    }
    return null;
  }

  public static String getMessageByName(String name) {
    for (ResultCode resultCode : ResultCode.values()) {
      if (resultCode.name().equals(name)) {
        return resultCode.message;
      }
    }
    return name;
  }

  public Integer getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  @Override
  public String toString() {
    return this.name();
  }

  public ResultVO toResponse() {
    return new ResultVO<>(this.code, this.message);
  }

  public ResultVO toResponseWithMessage(String message) {
    return new ResultVO<>(this.code, message);
  }

  public <T> ResultVO<T> toResponse(T data) {
    return new ResultVO<>(this.code, this.message, data);
  }

  public <T> ResultVO<T> toResponse(T data, String message) {
    return new ResultVO<>(this.code, message, data);
  }
}
