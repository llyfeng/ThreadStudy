package src.com.lyf.page6;

/**
 * @Author lyf
 * @Date 2020-08-18 20:48
 * @Description:
 */
public class ThreadB extends Thread{

  @Override
  public void run() {
    ThisOrClsssMonitor.printB();
  }
}
