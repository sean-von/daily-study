package com.smikevon.thrift;

import static com.smikevon.thrift.Something.*;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;


/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-11-24 下午4:02
 */
public class Client {


    public static void main(String[] args){
        try{
            TTransport transport = new TSocket("localhost",7911);
            TProtocol protocol = new TBinaryProtocol(transport);
            Something.Client client = new Something.Client(protocol);
            transport.open();
            System.out.println("Client calls ping()...");
            client.ping();
            transport.close();
        }catch(TException e){
            e.printStackTrace();
        }
    }
}
