package chat;

import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);

        while (true) {
            Socket socket = serverSocket.accept();

            ChatThread chatThread = new ChatThread(socket);
            chatThread.start();
        }
    }
}
class ChatThread extends Thread{
    private Socket socket;

    public ChatThread(Socket socket){
        this.socket = socket;
    }

    public void run(){

    }
}