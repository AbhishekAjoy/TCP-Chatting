import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client {

   public static void main(String [] args) {
      String serverName = args[0];
	Scanner read = new Scanner(System.in);
      int port = Integer.parseInt(args[1]);
      try {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         
         System.out.println("Just connected to " + client.getRemoteSocketAddress()+" \nEnter 'bye' to exit");
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
	 InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
	 String send = "sample";
	 while(!(send.equals("bye")))
	 {
	 System.out.println("User 1: ");
         send = read.nextLine();
         out.writeUTF(send);
	 String recv= in.readUTF();
	 System.out.println("User 2: ");
	 System.out.println(recv);
	 }
         
         
         client.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
