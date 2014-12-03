package com.smikevon.basic.language;


import com.smikevon.iterator.Collection;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-12-2 下午8:09
 */
public class TestLocalIp {

    public static void main(String[] args) throws SocketException {
        for(NetworkInterface nif : Collections.list(NetworkInterface.getNetworkInterfaces())){
            for(InetAddress address : Collections.list(nif.getInetAddresses())){

                System.out.println(address.isSiteLocalAddress());
                System.out.println(address.isLoopbackAddress());
                if(!address.isSiteLocalAddress()){

                }
                System.out.println(address.getHostAddress());
            }
        }
    }

}
