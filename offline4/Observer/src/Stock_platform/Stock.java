package Stock_platform;

import Publisher.provider;
import Users.Admin;
import Users.ConcreteSubscriber;
import Users.subscriber;

import java.io.File;
import java.util.Vector;

public class Stock {
    Vector<provider> providers;
    Vector<subscriber> subscribers;
    subscriber active;
    Stock(File f)
    {
        providers=new Vector<>();
        subscribers=new Vector<>();
        subscriber admin=new Admin();
        subscribers.add(admin);
        //file thk provider list

    }
   public void log_in(String s)
    {
        for(int i=0;i<subscribers.size();i++)
        {
            if(subscribers.get(i).getName().equalsIgnoreCase(s))
            {
                active=subscribers.get(i);
                return;
            }
        }
        subscriber sr=new ConcreteSubscriber(s);
        active=sr;
        subscribers.add(sr);
    }
    public void incPrice(String s,double d)
    {
        provider p=null;
        for(int i=0;i<subscribers.size();i++)
        {
            if(providers.get(i).getName().equalsIgnoreCase(s))
            {
                p=providers.get(i);
                break;
            }
        }
        if(p!=null)
        {
            if(active.getName().equalsIgnoreCase("admin"))
            p.increasePrice(d);
            else
            {
                //hobena print
            }
        }
    }
    public void decPrice(String s,double d)
    {
        provider p=null;
        for(int i=0;i<subscribers.size();i++)
        {
            if(providers.get(i).getName().equalsIgnoreCase(s))
            {
                p=providers.get(i);
                break;
            }
        }
        if(p!=null)
        {
            if(active.getName().equalsIgnoreCase("admin"))
                p.increasePrice(d);
            else
            {
                //hobena print
            }
        }
    }
    public void chngCount(String s,int d)
    {
        provider p=null;
        for(int i=0;i<subscribers.size();i++)
        {
            if(providers.get(i).getName().equalsIgnoreCase(s))
            {
                p=providers.get(i);
                break;
            }
        }
        if(p!=null)
        {
            if(active.getName().equalsIgnoreCase("admin"))
                p.increasePrice(d);
            else
            {
                //hobena print
            }
        }
    }

}
