package src.com.lyf.page1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author lyf
 * @Date 2020-06-19 10:39
 * @Description:
 */
public class RunnableCreate {


  public static class RunnableFirstTime implements Runnable {

    @Override
    public void run() {
      while (true) {
        System.out.println(Thread.currentThread().getName() + "create Runnable success!");
      }
    }
  }

  public static void main(String[] args) {
    //创建一个Thread线程，使用RunnableFirstTime
    Thread thread = new Thread(new RunnableFirstTime());
    //调用 Thread.start()方式启动线程
    thread.start();
  }
}
