package src.com.lyf.page3;

/**
 * @Author lyf
 * @Date 2020-06-29 19:26
 * @Description: SLEEP API 调试代码
 */
public class SleepTest {

  public static void main(String[] args) {
    new Thread(()->{

      try {
//        Thread.sleep(10000);
        //精确到纳秒的方法
        Thread.sleep(3,500001);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("10秒后"+Thread.currentThread().getName()+"出现了");

    },"班主任").start();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName()+"在2秒之后出现了");
  }
}
