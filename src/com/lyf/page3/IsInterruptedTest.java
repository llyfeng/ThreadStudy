package src.com.lyf.page3;

import java.util.concurrent.TimeUnit;

/**
 * @Author lyf
 * @Date 2020-07-05 11:30
 * @Description:
 */
public class IsInterruptedTest {

  private static class MyInterrupted implements Runnable {

    @Override
    public void run() {
      System.out.println("我已经被启动了");
      try {
        TimeUnit.SECONDS.sleep(10);
      } catch (InterruptedException e) {
        System.out.println("我被中断了");
      }
    }
  }

  public static void main(String[] args) {
    Thread thread = new Thread(new MyInterrupted(), "一号");
    System.out.println("线程未启动时候中断标志：" + thread.isInterrupted());
    thread.start();
    System.out.println("线程启动时候中断标志：" + thread.isInterrupted());
    thread.interrupt();
    System.out.println("线程启动并调用interrupt时候中断标志：" + thread.isInterrupted());

  }
}
