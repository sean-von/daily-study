package com.smikevon.thrift.message;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by fengxiao on 15-1-26.
 */
public class MessageServiceDemo {
    
    public static void main(String[] args){
        try {
            TServerSocket serverSocket = new TServerSocket(8085);
            
          // TCompactProtocol protocol = new TCompactProtocol.Factory().getProtocol();
        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
    
}
