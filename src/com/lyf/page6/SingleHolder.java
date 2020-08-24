package src.com.lyf.page6;

/**
 * @Author lyf
 * @Date 2020-08-10 14:29
 * @Description:
 */
public class SingleHolder {

  private byte[] date = new byte[1024];

  private SingleHolder() {

  }
  //内部静态类
  private static class Holder {

    private static SingleHolder singleHolder = new SingleHolder();
  }

  public static SingleHolder getInstance() {
    return Holder.singleHolder;
  }
}
