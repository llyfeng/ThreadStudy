package src.com.lyf.page3;

import java.util.concurrent.TimeUnit;

/**
 * @Author lyf
 * @Date 2020-07-05 15:24
 * @Description: 捕获中断信号关闭线程
 */
public class ExitThreadTest {

////捕获线程中断标志正常退出
//  public static void main(String[] args) throws InterruptedException {
//    Thread t1 = new Thread(() -> {
//      System.out.println("我要自测代码啦～～");
//      while (!Thread.currentThread().isInterrupted()) {
//        System.out.println("目前来看是好好的");
//      }
//      System.out.println("代码中断停止了");
//    });
//
//    t1.start();
//    TimeUnit.SECONDS.sleep(1);
//    t1.interrupt();
//
//  }

  //通过volatile关键字设置开关正常退出
  private static class MyInterrupted extends Thread {

    private volatile boolean close = false;

    @Override
    public void run() {
      System.out.println("我要开始自测代码啦～～");
      while (!close) {
        System.out.println("目前来看好好的");
      }
      System.out.println("close已经变成了" + close + "，代码正常关闭了");
    }

    public void closed() {
      this.close = true;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    MyInterrupted myInterrupted = new MyInterrupted();
    myInterrupted.start();
    TimeUnit.SECONDS.sleep(1);
    System.out.println("我要开始关闭线程了");
    myInterrupted.closed();
  }

}
