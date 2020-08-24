package src.com.lyf.page6;

/**
 * @Author lyf
 * @Date 2020-08-10 14:13
 * @Description: 懒汉式单例模式
 */
public class SingletonLazy {

  private byte[] date = new byte[1024];

  private static SingletonLazy singletonLazy = null;

  private SingletonLazy() {

  }

  public static SingletonLazy getInstance() {
    if (null == singletonLazy) {
      singletonLazy = new SingletonLazy();
    }
    return singletonLazy;
  }

//  //增加同步策略
//  public static synchronized SingletonLazy getInstance() {
//    if (null == singletonLazy) {
//      singletonLazy = new SingletonLazy();
//    }
//    return singletonLazy;
//  }
}
