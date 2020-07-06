package src.com.lyf.page3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;

/**
 * @Author lyf
 * @Date 2020-07-03 10:27
 * @Description:
 */
public class NIOBlockExample implements Runnable{

  private final SocketChannel socketChannel;

  public NIOBlockExample(SocketChannel sc) {
    this.socketChannel = sc;
  }

  @Override
  public void run() {
    try {
      System.out.println("Waiting for read() in " + this);
      socketChannel.read(ByteBuffer.allocate(1));
    } catch (ClosedByInterruptException e) {
      System.out.println(Thread.currentThread().getName()+"你炸啦！！！！！！！！！！！！");
      e.printStackTrace();
      System.out.println(Thread.currentThread().getName()+" = ClosedByInterruptException");
    } catch (AsynchronousCloseException e) {
      e.printStackTrace();
      System.out.println(Thread.currentThread().getName()+" = AsynchronousCloseException");
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    System.out.println(Thread.currentThread().getName()+" = Exiting NIOBlocked.run() " + this);
  }
}
