package Serverpkg;

import Stock_platform.platform;
import Users.ConcreteSubscriber;
import Users.subscriber;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class UserThread implements Runnable{
    private static Vector<subscriber> loggedinUsers = new Vector<>();
    private Socket connection;
    private subscriber active;
    private InputStream is;
    private OutputStream os;
    int id;
    private static platform p;
    private subscriber sb;
    UserThread(Socket s, int id, platform p)
    {
        connection=s;
        this.p=p;
        this.id=id;
        try {
            is=connection.getInputStream();
            os=connection.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(true) {
            String cmd;
            BufferedReader br = null;
            PrintWriter notify = null;
            try {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                notify = new PrintWriter(connection.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                cmd = br.readLine();
                StringTokenizer tokenizer = new StringTokenizer(cmd, " ");
                String[] userInput = new String[1000];
                int i = 0;
                //System.out.println(cmd);
                while (tokenizer.hasMoreTokens()) {
                    userInput[i] = tokenizer.nextToken();
                    i++;
                }

                if (userInput[0].equalsIgnoreCase("L")) {

                    sb = new ConcreteSubscriber(userInput[1]);
                    if (p.log_in(sb))
                    {
                        notify.println("Login Successful");
                        server.loggedUsers.add(notify);
                        loggedinUsers.add(sb);
                    }
                    else
                        notify.println("Username taken");


                }
                else if (userInput[0].equalsIgnoreCase("show")) {
                    //System.out.println("aise");
                    notify.println(p.show());

                }
                else if (userInput[0].equalsIgnoreCase("S")) {
                    //System.out.println("aise");
                    if(sb!=null) {
                        if (p.getPr(userInput[1]) != null) {
                            if(p.getPr(userInput[1]).subscribe(sb)==0)
                                notify.println("This was  subscribed before");
                            else
                            notify.println("Subscribed");
                        } else
                            notify.println("Can't find this product");
                    }
                    else
                        notify.println("Not logged in");
                }
                else if (userInput[0].equalsIgnoreCase("u")) {
                    //System.out.println("aise");
                    if(sb!=null) {
                    if(p.getPr(userInput[1])!=null)
                    {
                        if(p.getPr(userInput[1]).unsubscribe(sb)==0)
                            notify.println("This was not subscribed");
                        else
                        notify.println("Unsubscribed");
                    }
                    else
                        notify.println("Can't find this product");
                    }
                    else
                        notify.println("Not logged in");
                }
                else if (userInput[0].equalsIgnoreCase("I")) {
                    if(sb!=null)
                    {
                        if(sb.getName().equalsIgnoreCase("admin"))
                        {
                            if(p.incPrice(userInput[1],Double.parseDouble(userInput[2])))
                            {
                                for(int k=0;k<loggedinUsers.size();k++)
                                {
                                    PrintWriter pw=server.loggedUsers.get(k);
                                    if(pw.equals(notify)){
                                        continue;
                                    }
                                    else {
                                        if(p.hasSubscription(loggedinUsers.get(k),p.getPr(userInput[1])))
                                        pw.println("The price of product "+userInput[1]+" has increased by "+userInput[2]);
                                    }
                                }
                            }
                        }

                        else
                            notify.println("You don't have this access");
                    }
                    else
                        notify.println("Not logged in");

                }
                else if (userInput[0].equalsIgnoreCase("D")) {
                    if(sb!=null)
                    {
                        if(sb.getName().equalsIgnoreCase("admin"))
                        {
                            if(p.decPrice(userInput[1],Double.parseDouble(userInput[2]) ))
                            {
                                for(int k=0;k<loggedinUsers.size();k++)
                                {
                                    PrintWriter pw=server.loggedUsers.get(k);
                                    if(pw.equals(notify)){
                                        continue;
                                    }
                                    else {
                                        if(p.hasSubscription(loggedinUsers.get(k),p.getPr(userInput[1])))
                                        pw.println("The price of product "+userInput[1]+" has decreased by "+userInput[2]);
                                    }
                                }
                            }
                        }

                        else
                            notify.println("You don't have this access");
                    }
                    else
                        notify.println("Not logged in");


                }
                else if (userInput[0].equalsIgnoreCase("c")) {
                    if(sb!=null)
                    {
                        if(sb.getName().equalsIgnoreCase("admin"))
                        {
                            if(p.chngCount(userInput[1],Integer.parseInt(userInput[2])))
                            {
                                for(int k=0;k<loggedinUsers.size();k++)
                                {
                                    PrintWriter pw=server.loggedUsers.get(k);
                                    if(pw.equals(notify)){
                                        continue;
                                    }
                                    else {
                                        if(p.hasSubscription(loggedinUsers.get(k),p.getPr(userInput[1])))
                                           pw.println("The stock count of product "+userInput[1]+" has changed by "+userInput[2]);
                                    }
                                }
                            }
                        }

                        else
                            notify.println("You don't have this access");
                    }
                    else
                        notify.println("Not logged in");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
