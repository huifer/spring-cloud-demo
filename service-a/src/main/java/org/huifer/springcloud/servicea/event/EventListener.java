package org.huifer.springcloud.servicea.event;


import org.huifer.springcloud.servicea.base.HuiFerBaseInfo;

public interface EventListener extends HuiFerBaseInfo {

    /**
     * 信息
     *
     * @return 具体信息描述
     */
    @Override
    default String info() {
        return "事件监听器";
    }
}
