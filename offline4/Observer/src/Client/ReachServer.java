package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReachServer extends Thread{
    Socket user;
    String msg;
    public ReachServer(Socket s)
    {
        user=s;
        start();
    }

    @Override
    public void run() {
        super.run();
        while (true)
        {
            BufferedReader br=null;
            try
            {
                br=new BufferedReader(new InputStreamReader(user.getInputStream()));
                msg=br.readLine();
                System.out.println(msg);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
