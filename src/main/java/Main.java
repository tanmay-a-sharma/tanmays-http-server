import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;

public class Main {
  public static void main(String[] args) {
     // You can use print statements as follows for debugging, they'll be visible when running tests.
     System.out.println("Logs from your program will appear here!");
     ServerSocket serverSocket = null;
     Socket clientSocket = null;

     try {
       serverSocket = new ServerSocket(4221);
       serverSocket.setReuseAddress(true);

       // Wait for connection from client.
       clientSocket = serverSocket.accept();

       PrintWriter printWriter = new PrintWriter((clientSocket.getOutputStream()));
       printWriter.print("HTTP/1.1 200 OK\r\n\r\n");
       printWriter.flush();

       System.out.println("accepted new connection");

     } catch (IOException e) {
       System.out.println("IOException: " + e.getMessage());
     }
  }
}
