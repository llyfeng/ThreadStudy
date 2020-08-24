package src.com.lyf.page6;

import java.net.Socket;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @Author lyf
 * @Date 2020-08-10 14:19
 * @Description: Double-Check 单例模式
 */
public class DoubleCheck {

  private byte[] date = new byte[1024];

  private static DoubleCheck doubleCheck = null;
  private DoubleCheck() {
  }

  public static DoubleCheck getInstance(){

    if (null == doubleCheck) {
      synchronized (DoubleCheck.class) {
        if (null == doubleCheck) {
          doubleCheck = new DoubleCheck();
        }
      }
    }
    return doubleCheck;
  }
}
//  //Volatile 修饰防止重排序
//  private static volatile DoubleCheck doubleCheck = null;