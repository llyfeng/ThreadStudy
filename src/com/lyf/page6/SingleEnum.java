package src.com.lyf.page6;

/**
 * @Author lyf
 * @Date 2020-08-11 10:30
 * @Description: 枚举方式实现单例
 */
public enum SingleEnum {

  INSTANCE("我是","火车王");
  private String who;
  private String name;
  public String getWho() {
    return who;
  }

  public String getName() {
    return name;
  }
  private byte[] date = new byte[1024];

  SingleEnum(String who,String name){
    this.who = who;
    this.name = name;
    System.out.println("INSTANCE will be initialized immediately");
  }

  public static void method(){
    //调用该方法则会主动使用SingleEnum,INSTANCE 会被实例化
  }

  public static SingleEnum getInstance(){
    return INSTANCE;
  }



}
