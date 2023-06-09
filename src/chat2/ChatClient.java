package chat2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) throws Exception {
        if(args.length != 1 ){
            System.out.println("닉네임");
            return;
        }
        String name = args[0];
        Socket socket = new Socket("127.0.0.1", 8888);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        pw.println(name);
        pw.flush();
    }
}

class InputThread extends Thread {
    BufferedReader br;
    public InputThread(BufferedReader br) {
        this.br = br;
    }

    @Override
    public void run() {
        try {
            while (true){

            }
        }catch (Exception ex){
            System.out.println("...");
        }
    }
}
