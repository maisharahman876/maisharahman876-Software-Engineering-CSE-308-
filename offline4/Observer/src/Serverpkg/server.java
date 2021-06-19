package Serverpkg;

import Stock_platform.platform;
import Users.subscriber;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ForkJoinWorkerThread;

public class server {

    static int users=0;
    //static Vector<subscriber> list=new Vector<>(100);
    static Vector<PrintWriter> loggedUsers = new Vector<>();
    public static void main(String[] args) throws IOException {
        int id=1;
        File file =new File("input.txt");
        platform p=new platform(file);
        ServerSocket welcome=new ServerSocket(621);
        while(true)
        {
            Socket connection=null;
            try {
                connection= welcome.accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
            UserThread ut=new UserThread(connection,id,p);
            Thread t=new Thread(ut);
            t.start();
            System.out.println("user "+id+" is  connected.");
            id++;
            users++;
        }

    }
}
