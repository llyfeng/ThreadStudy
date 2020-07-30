package src.com.lyf.page5;

import java.util.concurrent.TimeUnit;

/**
 * @Author lyf
 * @Date 2020-07-29 15:55
 * @Description:
 */
public class ThreadClosealsTest {

  static volatile boolean started = true;

  public static void main(String[] args) {

    new Thread(() -> {
      boolean isEnd = started;
      while (isEnd == started) {
        System.out.println("开始学习");
      }
    }, "上课线程").start();

    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    new Thread(() -> {
      boolean b = started;
      b = false;
      started = b;
      System.out.println("学习结束");
    }, "下课线程").start();
  }


}
