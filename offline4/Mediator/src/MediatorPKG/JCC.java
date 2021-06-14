package MediatorPKG;

import Organizations.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class JCC implements Mediator{
    Organization jpdc,jrta,jtrc,jwsa;
    Queue<String> qd,qr,qw,qt;
    public JCC()
    {

        qd=new LinkedList<String>();
        qw=new LinkedList<String>();
        qt=new LinkedList<String>();
        qr=new LinkedList<String>();

    }
    public void collaborate(Organization d, Organization r, Organization w, Organization t)
    {
        jpdc=d;
        jwsa=w;
        jtrc=t;
        jrta=r;
        System.out.println("All four services are initiated through mediator");
    }
    @Override
    public void react_on_request(Organization o,String s)
    {
        if(s.equalsIgnoreCase("water"))
        {
            qw.add(o.toString());
            jwsa.addReq();

        }
       else if(s.equalsIgnoreCase("power"))
        {
           qd.add(o.toString());
            jpdc.addReq();

        }
       else if(s.equalsIgnoreCase("telecom"))
        {
           qt.add(o.toString());
            jtrc.addReq();

        }
       else if(s.equalsIgnoreCase("transport"))
        {
            qr.add(o.toString());
            jrta.addReq();

        }
       else
        {
            System.out.println("Service not Found");
        }

    }

    @Override
    public void receive(Organization o) {
        String s;
       if(o.toString().equalsIgnoreCase("jwsa"))
       {
           s=qw.poll();
           System.out.println("JWSA serves the request of "+s);
       }
       else if(o.toString().equalsIgnoreCase("jpdc"))
        {
            s=qd.poll();
            System.out.println("JPDC serves the request of "+s);
        }
       else if(o.toString().equalsIgnoreCase("jtrc"))
       {
           s=qt.poll();
           System.out.println("JTRC serves the request of "+s);
       }
       else if(o.toString().equalsIgnoreCase("jRTA"))
       {
           s=qr.poll();
           System.out.println("JRTA serves the request of "+s);
       }

    }
}
