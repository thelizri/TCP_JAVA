import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public Client() throws Exception{
        Socket socket = new Socket("localhost", 65413); //Connecting to server
        System.out.println("Successful connection to server");

        //IO Stream
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        String message = in_socket.readLine();
        System.out.println("Server says: "+message);
        out_socket.println("Hello back, mr server.");

        socket.close();
        System.out.println("Socket is closed");
    }
    public static void main(String[] args) {
        try {
            new Client();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
