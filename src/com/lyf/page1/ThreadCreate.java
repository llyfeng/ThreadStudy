package src.com.lyf.page1;

import java.io.FileOutputStream;

/**
 * @Author lyf
 * @Date 2020-06-19 10:21
 * @Description:
 */
public class ThreadCreate {

  public static class ThreadFirstTime extends Thread {

    @Override
    public void run() {
      while (true) {
        System.out.println(this.getName() + "create Thread success!");
      }
    }
  }

  public static void main(String[] args) {
    //第一种写法通过new ThreadFirstTime（）来创建对象
    ThreadFirstTime threadFirstTime = new ThreadFirstTime();
    //通过Thread.start()来启动线程
    threadFirstTime.start();

    //第二种 通过把new ThreadFirstTime()对象当作参数传入Thread的有参构造器中
    Thread thread = new Thread(new ThreadFirstTime());
    thread.start();
  }

}
