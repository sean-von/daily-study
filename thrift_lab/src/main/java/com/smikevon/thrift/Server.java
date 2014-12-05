package com.smikevon.thrift;

import static com.smikevon.thrift.Something.*;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-11-24 下午3:48
 */
public class Server {

    private void start(){
        try{
            TServerSocket serverTransport = new TServerSocket(7911);
            Processor processor = new Processor(new SomethingImpl());
            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory(true, true);
            TServer server = new TThreadPoolServer(processor, serverTransport, proFactory);
            System.out.println("Starting server on port 7911 ...");
            server.serve();

        }catch(TTransportException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String args[]){
        Server server = new Server();
        server.start();
    }
}
