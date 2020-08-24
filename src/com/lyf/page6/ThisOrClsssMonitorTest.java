package src.com.lyf.page6;

/**
 * @Author lyf
 * @Date 2020-08-18 20:50
 * @Description:
 */
public class ThisOrClsssMonitorTest {

  public static void main(String[] args) {
    ThreadA threadA = new ThreadA();
    threadA.setName("A");
    threadA.start();

    ThreadB threadB = new ThreadB();
    threadB.setName("B");
    threadB.start();

    ThreadC threadC = new ThreadC();
    threadC.setName("C");
    threadC.start();

  }
}
