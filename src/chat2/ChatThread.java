package chat2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatThread extends Thread{
    private String name;
    private BufferedReader br;
    private PrintWriter pw;
    private Socket socket;
    List<ChatThread> list;

    public ChatThread(Socket socket, List<ChatThread> list) throws Exception{
        this.socket = socket;
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.br = br;
        this.pw = pw;
        this.name = br.readLine();
        this.list.add(this);
    }

    public void sendMessage(String msg) {
        pw.println(msg);
        pw.flush();
    }

    @Override
    public void run() {
        String line = null;
        try {
            while ((line = br.readLine()) != null) {

            }
        } catch (Exception ex) {

        }
    }

    private void broadcast(String msg, boolean includeMe){
        List<ChatThread> chatThreads = new ArrayList<>();
        Collections.copy(chatThreads, this.list);

        try {
            for(int i=0; i< chatThreads.size(); i++) {
                ChatThread ct = chatThreads.get(i);
            }
        }catch (Exception ex){
            System.out.println("///");
        }
    }
}
