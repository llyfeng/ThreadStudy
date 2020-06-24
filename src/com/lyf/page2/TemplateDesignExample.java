package src.com.lyf.page2;

/**
 * @Author lyf
 * @Date 2020-06-24 18:58
 * @Description: 模版设计模式样例
 */
public class TemplateDesignExample {

  /**
   * 杯子
   */
  final void Teacup(String nothing){
    System.out.print("今天");
    Brewing(nothing);
    System.out.println("，愉快的一天开始啦！");
  }

  /**
   * 泡点什么呢
   * @param nothing
   */
  void Brewing(String nothing){
  }

  public static void main(String[] args) {
    TemplateDesignExample t1 = new TemplateDesignExample(){
      @Override
      void Brewing(String nothing){
        System.out.print("下雨，"+nothing);
      }
    };
    t1.Teacup("早上喝咖啡");


    TemplateDesignExample t2 = new TemplateDesignExample(){
      @Override
      void Brewing(String nothing){
        System.out.print("晴天，"+nothing);
      }
    };
    t2.Teacup("早上喝茶");
  }
}
