package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class User extends Thread{
    public User()
    {
        start();
    }

    public static void main(String[] args) throws IOException {
        String input;
        Socket user=new Socket("localhost",621);
        //BufferedReader br1=new BufferedReader(new InputStreamReader(user.getInputStream()));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(user.getOutputStream(),true);
        new ReachServer(user);
        while (true){
            input = br.readLine();
            //System.out.println(input);
            pw.println(input);
        }
    }
}
