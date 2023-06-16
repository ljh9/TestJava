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
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        pw.println(name);
        pw.flush();

        InputThread inputThread = new InputThread(br);
        inputThread.start();

        try {
            String line = null;
            while ((line = keyboard.readLine()) != null){
                if ("/quit".equals(line))
                    break;
                pw.println(line);
                pw.flush();
            }
        }catch (Exception ex){
            System.out.println("...");
        }
        try {
            br.close();
        }catch (Exception ex){

        }
        try {
            pw.close();
        }catch (Exception ex){

        }
        try {
            socket.close();
        }catch (Exception ex){

        }
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
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception ex){
            System.out.println("...");
        }

    }
}
