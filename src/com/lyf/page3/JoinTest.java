package src.com.lyf.page3;

import java.util.concurrent.TimeUnit;

/**
 * @Author lyf
 * @Date 2020-07-05 14:10
 * @Description: Join 测试
 */
public class JoinTest {

  public static void main(String[] args) throws InterruptedException {

    Thread t1 = new Thread(() -> {
      System.out.println("周末都要加班，终于回家了，洗个手吃饭了");
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.print("洗完手,");
    });

    Thread t2 = new Thread(() -> {
      try {
        TimeUnit.SECONDS.sleep(2);
        t1.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.print("拿起筷子,");
    });

    t1.start();
    t2.start();
    t2.join();
    System.out.println("我要吃饭了");

  }
}
