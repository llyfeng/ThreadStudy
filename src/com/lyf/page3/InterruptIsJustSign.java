package src.com.lyf.page3;

import java.util.concurrent.TimeUnit;

/**
 * @Author lyf
 * @Date 2020-07-05 10:54
 * @Description: interrupt只是打上中断标志而不是直接让线程中断
 */
public class InterruptIsJustSign {

  private static class MySleep implements Runnable {

    @Override
    public void run() {
      try {
        TimeUnit.SECONDS.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      for (int i = 0; i < 10; i++) {
        System.out.println("我一直都在");
      }
    }
  }

  public static void main(String[] args) {

    Thread thread = new Thread(new MySleep(), "我是个没有感情的标签");
    thread.start();
    System.out.println("我开始打断你");
    thread.interrupt();
    System.out.println("你已经被我打断了");

  }
}
