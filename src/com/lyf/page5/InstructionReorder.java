package src.com.lyf.page5;


/**
 * @Author lyf
 * @Date 2020-07-22 13:48
 * @Description: 指令重排序演示
 */
public class InstructionReorder {


  public static class PrintOut {
    public void getStr() {
      System.out.println(Thread.currentThread().getName() + "返回了呗");
    }
  }

  private static boolean initStatus = false;
  static PrintOut printOut = null;

  public static void main(String[] args) {
    new Thread(() -> {
      //判断当前singleExample是否已经是实例化
      if (!initStatus) {
        //模拟指令重排序
        initStatus = true;
        printOut = new PrintOut();
        printOut.getStr();
//        //未进行指令重排序
//        initStatus = true;
      } else {
        printOut.getStr();
      }
    }, "一号线程").start();

    new Thread(() -> {
      //判断当前singleExample是否已经是实例化
      if (!initStatus) {
        printOut = new PrintOut();
        printOut.getStr();
        initStatus = true;
      } else {
        printOut.getStr();
      }
    }, "二号线程").start();
  }
}
