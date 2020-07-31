package com.xhs.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.annotation.JmsListeners;
import org.springframework.stereotype.Component;

/**
 * @author xuhangsong
 * @since 2020/7/31
 */
@Component
public class Consumer {
    /**
     * 接收queue类型消息
     * destination对应配置类中ActiveMQQueue("springboot.queue")设置的名字
     */
    @JmsListener(destination = "springboot.queue")
    public void ListenQueue(String msg) {
        System.out.println("接收到queue消息：" + msg + Math.random());
    }

    /**
     * 接收topic类型消息
     * destination对应配置类中ActiveMQTopic("springboot.topic")设置的名字
     * containerFactory对应配置类中注册JmsListenerContainerFactory的bean名称
     *
     * @param msg
     */

    @JmsListener(destination = "springboot.topic", containerFactory = "jmsTopicListenerContainerFactory")
    public void listenTopic(String msg) {
        System.out.println("接收到topic消息：" + msg + Math.random());
    }

    @JmsListener(destination = "springboot.topic", containerFactory = "jmsTopicListenerContainerFactory")
    public void listenTopic2(String msg) {
        System.out.println("接收到topic2消息：" + msg + Math.random());
    }

//    @JmsListeners({@JmsListener(destination = "springboot.queue"), @JmsListener(destination = "springboot.topic", containerFactory = "jmsTopicListenerContainerFactory")})
//    public void listenQueueAndTopic(String msg) {
//        System.out.println("接收到queue or topic消息：" + msg + Math.random());
//    }
}
