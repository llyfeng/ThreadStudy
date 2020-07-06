package src.com.lyf.page3;

/**
 * @Author lyf
 * @Date 2020-07-01 10:29
 * @Description: YIELD API 调试代码
 */
public class YieldTest {

  private static class MyYield implements Runnable {

    @Override
    public void run() {
      for (int i = 0; i < 5; i++) {
        if (i % 5 == 0) {
          System.out.println(Thread.currentThread().getName() + "线程，yield 它出现了");

//          Thread.yield();
        }
      }

      System.out.println(Thread.currentThread().getName() + "结束了");
    }
  }

  public static void main(String[] args) {
    Thread t1 = new Thread(new MyYield());
    t1.start();

    Thread t2 = new Thread(new MyYield());
    t2.start();

    Thread t3 = new Thread(new MyYield());
    t3.start();
  }
}
