package org.huifer.springcloud.servicea.scheduling;


import org.huifer.springcloud.servicea.base.HuiFerBaseInfo;

/**
 * 标记,请勿修改
 */
public interface InProjectScheduling extends HuiFerBaseInfo {


    /**
     * 信息
     *
     * @return 这是一个定时任务标记接口
     */
    @Override
    default String info() {
        return "这是一个定时任务标记接口";
    }
}
