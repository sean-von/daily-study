package com.smikevon.concurrent;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by fengxiao on 15-1-6.
 */
public class FutureCase {

    final static ExecutorService executorService = Executors.newCachedThreadPool();

    private static class ReadDB implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println("start the DB session");
            Thread.sleep(10000);
            System.out.println("now got the DB session");
            return getUser();
        }

        public String getUser(){
            return "fengxiao";
        }
    }

    public static void main(String[] args) throws Exception{
        //customFutureGet();
        //guavaFuture();
        test_futures();
    }

    /**
     * 使用java concurrent包完成异步事件
     */
    public static void customFutureGet(){
        System.out.println("now,I get user name from DB");
        Future<String> future = executorService.submit(new ReadDB());
        try {
            System.out.println("request has send,then I wait ... ");
            String name = future.get();
            System.out.println("now,I get the user his name is "+name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用guava异步监听完成事件
     */
    public static void guavaFuture(){
        System.out.println("now,I get user name from DB");
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        ListenableFuture<String> futrue = service.submit(new ReadDB());
        Futures.addCallback(futrue,new FutureCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("now,I get the user his name is "+s);
            }

            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

        System.out.println("I can do other things");
    }

    public static void test_futures() throws ExecutionException, InterruptedException {
        final ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));

        ListenableFuture<Integer> future1 = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                System.out.println("now Call future 1");
                return 1;
            }
        });

        ListenableFuture<Integer> future2 = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(8000);
                System.out.println("now Call future 1");
                return 2;
            }
        });

        ListenableFuture<List<Integer>> futureList = Futures.allAsList(future1,future2);

        ListenableFuture<Boolean> transform = Futures.transform(futureList,new AsyncFunction<List<Integer>,Boolean>() {

            @Override
            public ListenableFuture<Boolean> apply(List<Integer> integers) throws Exception {
                System.out.println("the result size : "+ integers.size());
                return Futures.immediateFuture(integers.size()>0);
            }
        });

        Futures.addCallback(transform,new FutureCallback() {
            @Override
            public void onSuccess(Object o) {
                System.out.println(o.getClass());
                System.out.println(o);
                //service.shutdownNow();
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });

        System.out.println(transform.get());
    }

}
