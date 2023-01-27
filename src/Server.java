import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws Exception{
        //Opening port
        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("Port 2020 has been opened");

        //Accepting connection
        Socket socket = serverSocket.accept();
        System.out.println("Client "+socket.getInetAddress()+" has connected");

        //IO Buffers
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        out_socket.println("Hello client! Welcome to this TCP connection."); //Send message to client
        String message = in_socket.readLine(); //Get message from client
        System.out.println("Client says: "+message);

        socket.close();
        System.out.println("Socket is closed");
    }
    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}