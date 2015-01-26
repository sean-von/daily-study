package com.smikevon.concurrent;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fengxiao on 15-1-6.
 */
public class FuturesCase {
    //ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));
    private static ExecutorService service = Executors.newCachedThreadPool();
    
    
    public static void main(String[] args){

        System.out.println("hello start ...");
        service.submit(new SendWorker(""));
        System.out.println("hello end ...");
        
    }

    private static class SendWorker implements Callable {

        private Object messages;

        SendWorker(Object messages){
            this.messages = messages;
        }

        @Override
        public Object call() throws Exception {
            Thread.sleep(5000);
            System.out.println("worker thread print ...");
            return null;
        }
    }
}
