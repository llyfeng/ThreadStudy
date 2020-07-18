package src.com.lyf.page4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @Author lyf
 * @Date 2020-07-14 19:16
 * @Description: 线程不安全问题演示
 */
public class UnSafeThreadExample implements Runnable {

  private int sum = 1;
  private final static int MAX = 500;

  @Override
  public void run() {
    while (sum <= MAX) {
      System.out.println("当前已经有:" + (sum++) + "人点赞");
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

//  public static void main(String[] args) {
//    final UnSafeThreadExample unSafeThreadExample = new UnSafeThreadExample();
//    for (int i = 0; i < 5; i++) {
//      new Thread(unSafeThreadExample).start();
//
//    }
//  }

  /**
   * 传null的情况
   * @param args
   */
  public static void main(String[] args) {
    UnSafeThreadExample t = null;
    synchronized (t) {
      synchronized (t) {
        System.out.println("made it!");
      }
    }
  }



}
