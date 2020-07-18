package src.com.lyf.page4;

/**
 * @Author lyf
 * @Date 2020-07-18 12:41
 * @Description:
 */
public class DeathLockExample {

  //点赞
  private final static Object GIVE_THE_THUMBS_UP = new Object();
  //取消点赞
  private final static Object GIVE_THE_THUMBS_OFF = new Object();

  public void up() {
    synchronized (GIVE_THE_THUMBS_UP) {
      synchronized (GIVE_THE_THUMBS_OFF) {
        System.out.println("我要给你点赞");
      }
      System.out.println("系统提示：点赞成功");
    }
  }


  public void off() {
    synchronized (GIVE_THE_THUMBS_OFF) {
      synchronized (GIVE_THE_THUMBS_UP) {
        System.out.println("我要取消给你点赞");
      }
      System.out.println("系统提示：取消点赞成功");
    }
  }

  public static void main(String[] args) {
    DeathLockExample deathLockExample = new DeathLockExample();

    new Thread(() -> {
      while (true) {
        deathLockExample.up();
      }
    }, "点赞线程").start();

    new Thread(() -> {
      while (true) {
        deathLockExample.off();
      }
    }, "取消点赞线程").start();

  }
}
