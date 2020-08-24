package src.com.lyf.page6;

/**
 * @Author lyf
 * @Date 2020-08-11 10:34
 * @Description:
 */
public class SingleEnum2 {


  private byte[] date = new byte[1024];

  private SingleEnum2() {
    System.out.println("INSTANCE will be initialized immediately");
  }

  private enum EnumHolder {
    INSTANCE;
    private SingleEnum2 singleEnum2;

    EnumHolder() {
      this.singleEnum2 = new SingleEnum2();
    }

    private SingleEnum2 getSingleEnum2() {
      return singleEnum2;
    }

  }

  public static void method(){
    //调用该方法 INSTANCE不 会被实例化
  }

  public static SingleEnum2 getInstance() {
    return EnumHolder.INSTANCE.getSingleEnum2();
  }
}
