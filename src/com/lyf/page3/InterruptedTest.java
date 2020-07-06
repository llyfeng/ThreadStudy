package src.com.lyf.page3;

import java.util.concurrent.TimeUnit;


/**
 * @Author lyf
 * @Date 2020-07-05 11:44
 * @Description: interrupted 测试
 */
public class InterruptedTest {

  public static void main(String[] args) {

    System.out.println("调用中断方法之前isInterrupted()标记为：" + Thread.currentThread().isInterrupted());
    System.out.println("调用中断方法之前interrupted标记为：" + Thread.interrupted());
    Thread.currentThread().interrupt();
    System.out.println("调用中断方法之后isInterrupted()标记为，第一次输出：" + Thread.currentThread().isInterrupted());
    System.out.println("interrupted()标记为，第一次输出：" + Thread.interrupted());
    System.out.println("isInterrupted()标记为，第二次输出：" + Thread.currentThread().isInterrupted());
    System.out.println("interrupted()标记为，第二次输出：" + Thread.interrupted());
  }
}
