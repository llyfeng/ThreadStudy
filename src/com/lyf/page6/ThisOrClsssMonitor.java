package src.com.lyf.page6;

/**
 * @Author lyf
 * @Date 2020-08-18 20:46
 * @Description: this monitor 和class monitor
 */
public class ThisOrClsssMonitor {
  synchronized public static void printA() { //Class锁
    try {
      System.out.println("线程"+Thread.currentThread().getName()+"进入printA");
      Thread.sleep(2000);
      System.out.println("线程" +Thread.currentThread().getName()+"离开printA");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  synchronized public static void printB() {  //Class锁
    try {
      System.out.println("线程"+Thread.currentThread().getName()+"进入printB");
      Thread.sleep(2000);
      System.out.println("线程" +Thread.currentThread().getName()+"离开printB");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  synchronized public void printC() {  //对象锁
    try {
      System.out.println("线程"+Thread.currentThread().getName()+"进入printC");
      Thread.sleep(2000);
      System.out.println("线程" +Thread.currentThread().getName()+"离开printC");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
