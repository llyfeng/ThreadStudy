package src.com.lyf.page6;

/**
 * @Author lyf
 * @Date 2020-08-18 20:49
 * @Description:
 */
public class ThreadC extends Thread{

  private ThisOrClsssMonitor thisOrClsssMonitor = new ThisOrClsssMonitor();
  @Override
  public void run() {
    thisOrClsssMonitor.printC();
  }
}
