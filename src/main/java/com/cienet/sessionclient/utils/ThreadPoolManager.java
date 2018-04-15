//package com.cienet.sessionclient.utils;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.Executors;
//import java.util.concurrent.RejectedExecutionHandler;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.ScheduledFuture;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
///**
// * @program: session-client
// * @description: 线程池管理类
// * @author: SunWei
// * @create: 2018-04-15 14:01
// **/
//public class ThreadPoolManager {
//    private static ThreadPoolManager tpm = new ThreadPoolManager();//单例
//
//    private final static int CORE_POOL_SIZE =4;//线程池维护线程的最小数量。
//
//    private final static int  MAX_POOL_SIZE = 10;//线程池维护线程的最大数量。
//
//    private final static int KEEP_ALIVE_TIME = 0;//线程池维护线程所允许的空闲时间。
//
//    private final static int WORK_QUEUE_SIZE = 10;//线程池所使用的缓冲队列大小。
//
//    Queue msgQueue = new LinkedList();//消息缓冲队列
//
//    //访问消息缓存的调度线程
//    //查看是否有待定请求，如果有，则创建一个新的AccessDBThread并添加到线程池中。
//    final Runnable accessBufferThread = new Runnable() {
//
//        public void run() {
//
//            if(hasMoreAcquire()) {
//                String msg = (String)msgQueue.poll();
//                threadPool.execute(new AccessDBThread(msg));
//            }
//        }
//    };
//
//    final RejectedExecutionHandler handler = new RejectedExecutionHandler() {
//
//        public void rejectedExecution(Runnable arg0, ThreadPoolExecutor arg1) {
//            System.out.println(((AccessDBThread)arg0).getMsg()+"消息放入队列中重新等待执行");
//            msgQueue.offer(((AccessDBThread)arg0).getMsg());
//        }
//    };
//
//    //管理工作线程的线程池
//    final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new ArrayBlockingQueue(WORK_QUEUE_SIZE),this.handler);
//
//
//    //调度线程池
//    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(100);
//
//    final ScheduledFuture taskHandler = scheduler.scheduleAtFixedRate(accessBufferThread, 0, 1, TimeUnit.SECONDS);
//
//    public static ThreadPoolManager newInstance() {
//        return tpm;
//    }
//
//    private ThreadPoolManager(){}
//
//    private boolean hasMoreAcquire(){
//        return !msgQueue.isEmpty();
//    }
//
//    public void addLogMsg(String msg) {
//        threadPool.execute(new AccessDBThread(msg));
//    }
//}
