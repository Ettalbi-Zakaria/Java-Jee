package ma.enset.blocking;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class MultiThreadServer extends Thread{
    int clientsCount;
    public static void main(String[] args) {
        new MultiThreadServer().start();
    }

    @Override
    public void run() {
        System.out.println("The server is started using port : 1234");
        try {
            ServerSocket ss = new ServerSocket(1234);
            while (true){
                Socket s = ss.accept();
                ++clientsCount;
                new Conversation(s,clientsCount).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    class Conversation extends  Thread{
        private Socket socket ;
        private int clienID;
        public  Conversation(Socket socket, int clienID){
            this.socket=socket;
            this.clienID= clienID;
        }

        @Override
        public void run() {
            try {
                SocketAddress ip = socket.getRemoteSocketAddress();
                System.out.println("new client connection : " + clienID+ " ip : "+ip);
                //lire une chaine
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                //ecrire une chaine
                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os,true);
                pw.println("Bienvenue votre ID : " + clienID);
                String request ;
                while ((request = br.readLine())!=null){
                    System.out.println("New request => IP : "+ip+"  Request : "+request);
                    String reponse = "Size : " + request.length();
                    pw.println(reponse);
                }
            }catch (IOException E){
                E.printStackTrace();
            }
        }
    }
}
