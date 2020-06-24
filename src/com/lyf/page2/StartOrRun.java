package src.com.lyf.page2;

/**
 * @Author lyf
 * @Date 2020-06-24 18:45
 * @Description: start 和 run之间的区别
 */
public class StartOrRun {

  public static class TestStartAndRun implements Runnable{

    @Override
    public void run() {

      System.out.println("我的名字叫"+Thread.currentThread().getName());
    }
  }


  public static void main(String[] args) {

    new Thread(new TestStartAndRun(),"start").start();

    new Thread(new TestStartAndRun(),"run").run();

  }
}
