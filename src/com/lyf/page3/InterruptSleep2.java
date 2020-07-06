package src.com.lyf.page3;

import java.util.concurrent.TimeUnit;


/**
 * @Author lyf
 * @Date 2020-07-02 20:30
 * @Description: 解析 interrupt代码
 */
public class InterruptSleep2 {

  private static class MySleep implements Runnable {

    @Override
    public void run() {
      System.out.println("下班啦，我要睡觉了，谁也别来吵我");
      try {
        TimeUnit.HOURS.sleep(12);
      } catch (InterruptedException e) {
        System.out.println("你代码炸啦！！！");
//        e.printStackTrace();
      }
      System.out.println("起床");
    }
  }


  public static void main(String[] args) {

    Thread t1 = new Thread(() -> {
      Thread t2 = new Thread(new MySleep(), "一号");
      t2.start();
      t2.interrupt();
    }, "二号");
    t1.start();
  }
}
