package com.smikevon.thrift;

import org.apache.thrift.TException;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-11-24 下午3:46
 */
public class SomethingImpl implements Something.Iface {

    @Override
    public int ping() throws TException {
        System.out.println("receive ping from client!");
        return 0;
    }
}
