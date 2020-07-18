package src.com.lyf.page4;

import java.util.concurrent.TimeUnit;

/**
 * @Author lyf
 * @Date 2020-07-17 16:32
 * @Description:
 */
public class SafeThreadExample implements Runnable {

  private Integer sum = 1;
  private final static int MAX = 500;
  private final static Object MUTEX = new Object();

  @Override
  public void run() {
    synchronized (MUTEX) {
      while (sum <= MAX) {
        System.out.println("当前已经有:" + (sum++) + "人点赞");
//        try {
////          Thread.sleep(10);
////          TimeUnit.MINUTES.sleep(5);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
      }
    }
  }

  public static void main(String[] args) {
    final SafeThreadExample safeThreadExample = new SafeThreadExample();
    for (int i = 0; i < 5; i++) {
      new Thread(safeThreadExample).start();
    }
  }
}
