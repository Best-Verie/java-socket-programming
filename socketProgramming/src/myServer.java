import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;

public class myServer {
    public static  void main(String args[]) throws Exception{
     ServerSocket server=new ServerSocket(8090);
     Socket mySocket=server.accept();


     DataInputStream input=new DataInputStream(mySocket.getInputStream());
     DataOutputStream output=new DataOutputStream(mySocket.getOutputStream());


     String request=" ";
     String response=" ";

     BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       while(!request.equals("Exit")){
           request=input.readUTF();
           System.out.println("Request received: " + request);
           System.out.println("Enter a response: ");
           response=reader.readLine();

           output.writeUTF(response);
           output.flush();
        }
       input.close();
       mySocket.close();
    }
}
