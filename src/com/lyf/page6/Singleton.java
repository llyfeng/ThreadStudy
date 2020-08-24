package src.com.lyf.page6;

/**
 * @Author lyf
 * @Date 2020-08-10 14:01
 * @Description: 饿汉式单例模式
 */
public class Singleton {

  private byte[] date = new byte[1024];

  private static Singleton instance = new Singleton();

  private Singleton() {
  }

  public static Singleton getInstance() {
    return instance;
  }
}
