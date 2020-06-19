package src.com.lyf.page1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author lyf
 * @Date 2020-06-19 13:23
 * @Description:
 */
public class FutureTaskCreate {

  public static class CallerTask implements Callable<String> {

    @Override
    public String call() throws Exception {
      return Thread.currentThread().getName() + "create FutureTask success!";
    }
  }

//  //用于测试FutureTask使用Runnable来实现创建
//  public static class RunnableFirstTime implements Runnable {
//
//    @Override
//    public void run() {
//      System.out.println(Thread.currentThread().getName() + "create Runnable success!");
//    }
//  }

  public static void main(String[] args) {
    //创建异步任务
    FutureTask<String> futureTask = new FutureTask<>(new CallerTask());

//    //用于测试FutureTask使用Runnable来实现创建
//    FutureTask<String> futureTask = new FutureTask<>(new RunnableFirstTime(),"create FutureTask success!");

//    //不带返回参数的调用方式，和Runnable效果一毛一样
//    FutureTask<Void> futureTask = new FutureTask<>(new RunnableFirstTime(),null);

    //创建线程，调用Thread.start()启动线程
    new Thread(futureTask).start();

    //获取线程返回结果
    try {
      String result = futureTask.get();
      System.out.println(result);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }
}
