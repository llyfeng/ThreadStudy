package src.com.lyf.page3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Author lyf
 * @Date 2020-07-02 20:53
 * @Description:
 */
public class InterruptNIO {


  public static void main(String[] args) throws IOException, InterruptedException {
    ServerSocket server = new ServerSocket(8080);
    InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
    SocketChannel sc1 = null;
    SocketChannel sc2 = null;
    try {
      sc1 = SocketChannel.open(isa);
      sc2 = SocketChannel.open(isa);
    } catch (ClosedByInterruptException e) {

    }

    Thread t1 = new Thread(new NIOBlockExample(sc2), "一号");
    t1.start();

    Thread t2 = new Thread(new NIOBlockExample(sc1), "二号");
    t2.start();
    //打断标志
    t1.interrupt();
    t2.interrupt();

  }
}
