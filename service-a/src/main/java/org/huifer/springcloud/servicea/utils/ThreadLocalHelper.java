package org.huifer.springcloud.servicea.utils;

public class ThreadLocalHelper {

  private static ThreadLocal<Integer> DEPT = new ThreadLocal<>();

  public static Integer getDept() {
    return DEPT.get();
  }

  public static void setDept(Integer deptId) {
    if (deptId == null) {
      DEPT.remove();
    } else {
      DEPT.set(deptId);
    }
  }


}