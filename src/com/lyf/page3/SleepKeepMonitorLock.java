package src.com.lyf.page3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lyf
 * @Date 2020-06-30 14:47
 * @Description: 验证sleep不会释放monitor lock
 */
public class SleepKeepMonitorLock {

  /**
   * 创建一个独占锁
   */
  private static final Lock lock = new ReentrantLock();

  public static void main(String[] args) {

    new Thread(new Runnable() {
      @Override
      public void run() {
        lock.lock();
        System.out.println("我是" + Thread.currentThread().getName() + "，lock在我手中");
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
          System.out.println(Thread.currentThread().getName() + "不需要lock了");
        }

      }
    }, "一号线程").start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        lock.lock();
        System.out.println("我是" + Thread.currentThread().getName() + "，lock在我手中");
        try {
          Thread.sleep(3000);
//          //使用TimeUnit枚举类
//          TimeUnit.HOURS.sleep(1);
//          TimeUnit.MINUTES.sleep(28);
//          TimeUnit.SECONDS.sleep(19);
//          TimeUnit.MILLISECONDS.sleep(33);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
          System.out.println(Thread.currentThread().getName() + "不需要lock了");
        }

      }
    }, "二号线程").start();

  }
}
