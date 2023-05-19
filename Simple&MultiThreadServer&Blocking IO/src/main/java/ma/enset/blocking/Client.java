package ma.enset.blocking;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",1234);

        //envoyer une chaine de caractére
        OutputStream os = s.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        //lire une chaine de caractére
        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        //pour un client iL faut Separer la partie lire et ecrice
        //lire
        new Thread(() ->{
            String request ;
            try {
                while((request = br.readLine())!=null){
                    System.out.println(request);
                }
            }catch (IOException E){
                E.getMessage();
            }

        }).start();

        //ecrire
        Scanner sc = new Scanner(System.in);
        while (true){
            String reponse = sc.nextLine();
            pw.println(reponse);
        }
    }
}
