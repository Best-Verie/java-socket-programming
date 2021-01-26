import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class myClient {
    public static void main(String args[]) throws  Exception{
        Socket clientSocket=new Socket("localhost", 8090);

        DataInputStream input=new DataInputStream(clientSocket.getInputStream());
        DataOutputStream output=new DataOutputStream(clientSocket.getOutputStream());

        String request=" ";
        String response=" ";

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        while (!request.equals("Exit")){
            System.out.println("Enter a request: ");
            request=reader.readLine();
            output.writeUTF(request);
            output.flush();

            response=input.readUTF();
            System.out.println("response is: " +response);
        }

        input.close();
        clientSocket.close();

    }
}
