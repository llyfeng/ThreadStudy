package src.com.lyf.page3;

import java.util.concurrent.TimeUnit;

/**
 * @Author lyf
 * @Date 2020-07-02 19:00
 * @Description: 中断处于sleep状态的线程
 */
public class InterruptSleep {

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
    Thread thread = new Thread(new MySleep());
    thread.start();
    //调用中断方法
    thread.interrupt();
  }
}
