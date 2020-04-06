package org.huifer.springcloud.servicea.intercepter;

import org.huifer.springcloud.servicea.base.BaseController;
import org.huifer.springcloud.servicea.utils.ThreadLocalHelper;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
public class SiteHandlerInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler) throws Exception {
    ThreadLocalHelper.setDept(null);

    if (!(handler instanceof HandlerMethod)) {
      return true;
    }
    // 请求地址
    String uri = request.getRequestURI();

    if (isPublic(handler)) {
      return true;
    }
    // 移动端,webd端校验
    // 获取用户service

//        操作获取人

    // 权限判断

    // 一些操作真正的dept

    ThreadLocalHelper.setDept(1);

    return true;
  }

  private boolean isPublic(Object handler) {
    boolean result = true;
    if (handler!=null) {
      HandlerMethod handlerMethod = (HandlerMethod) handler;
      if (handlerMethod.getBean() instanceof BaseController) {
        BaseController controller = (BaseController) handlerMethod.getBean();
        result = controller.isPublic();
      }

    }
    return result;
  }
}
