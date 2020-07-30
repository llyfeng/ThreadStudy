package src.com.lyf.page5;

import java.util.concurrent.TimeUnit;

/**
 * @Author lyf
 * @Date 2020-07-20 15:11
 * @Description: 初识volatile
 */
public class VolatileTest {

   final static int MAX = 5;
  static volatile int init_value = 0;
//   static int init_value = 0;

  public static void main(String[] args) {
    new Thread(() ->
    {
      int localValue = init_value;
      while (localValue < MAX) {
        if (init_value != localValue) {
          System.out.println("value read to "+init_value);
          localValue = init_value;
        }
      }
    }, "Reader").start();

    //保证 读线程先启动
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    new Thread(() ->
    {
      int localValue = init_value;
      while (localValue < MAX) {
        System.out.println("value update to "+(++localValue));
        init_value = localValue;
        try {
          TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }, "Updater").start();
  }
}
