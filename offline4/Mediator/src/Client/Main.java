package Client;

import MediatorPKG.JCC;
import MediatorPKG.Mediator;
import Organizations.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mediator m=new JCC();
        Organization jpdc=new JPDC(m);
        Organization jrta=new JRTA(m);
        Organization jtrc=new JTRC(m);
        Organization jwsa=new JWSA(m);

        while(true)
        {
            Scanner sc=new Scanner(System.in);
            String s=sc.next();
            if(s.equalsIgnoreCase("init"))
            {
                m.collaborate(jpdc,jrta,jwsa,jtrc);
            }
            else if(s.equalsIgnoreCase("jwsa"))
            {
                String e=sc.next();
                if(e.equalsIgnoreCase("serve"))
                {
                    jwsa.serve();
                }
                else
                jwsa.request(e);
            }
            else if(s.equalsIgnoreCase("jtrc"))
            {
                String e=sc.next();
                if(e.equalsIgnoreCase("serve"))
                {
                    jtrc.serve();
                }
                else
                    jtrc.request(e);

            }
            else if(s.equalsIgnoreCase("jrta"))
            {
                String e=sc.next();
                if(e.equalsIgnoreCase("serve"))
                {
                    jrta.serve();
                }
                else
                    jrta.request(e);

            }
            else if(s.equalsIgnoreCase("jpdc"))
            {
                String e=sc.next();
                if(e.equalsIgnoreCase("serve"))
                {
                    jpdc.serve();
                }
                else
                    jpdc.request(e);
            }
            else
            {
                System.out.println("Command not Found");
            }

        }
    }
}
