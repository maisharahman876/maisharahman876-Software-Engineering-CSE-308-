package Stock_platform;

import stock.product;
import Users.ConcreteSubscriber;
import Users.subscriber;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class platform {
    Vector<product> products;
    Vector<subscriber> subscribers;
    //subscriber active;
    public platform(File f) throws FileNotFoundException {
        products=new Vector<>();
        subscribers=new Vector<>();
        Scanner sc=new Scanner(f);
        while (sc.hasNextLine())
        {
            String pr=sc.next();
            int st=sc.nextInt();
            float val=sc.nextFloat();
            product p=new product(pr,st,val);
            products.add(p);
        }
        //subscriber admin=new Admin();
        //subscribers.add(admin);
        //file thk provider list

    }
    public  String show()
    {
        String s=new String();
        for (int i=0;i<products.size();i++)
        {
           s= s+products.get(i).toString()+"    ";
        }
        return s;
    }
    public int prSize()
    {
        return products.size();
    }
    public product getPr(String s)
    {
        for (int i=0;i<products.size();i++)
        {
            if(s.equalsIgnoreCase(products.get(i).getName()))
                return products.get(i);
        }
        return null;
    }
   public boolean log_in(subscriber sc)
   {
        for (int i=0;i<subscribers.size();i++)
        {
            if(subscribers.get(i).getName().equalsIgnoreCase(sc.getName()))
                return false;
        }
        subscribers.add(sc);
        return true;
    }
    public boolean incPrice(String s,double d)
    {
        product p=null;

        for(int i=0;i<subscribers.size();i++)
        {
            if(products.get(i).getName().equalsIgnoreCase(s))
            {
                p=products.get(i);
                break;
            }
        }
        if(p!=null)
        {
           p.increasePrice(d);
           return true;

        }
        return false;
    }
    public boolean decPrice(String s,double d)
    {
        product p=null;

        for(int i=0;i<subscribers.size();i++)
        {
            if(products.get(i).getName().equalsIgnoreCase(s))
            {
                p=products.get(i);
                break;
            }
        }
        if(p!=null)
        {
            p.decreasePrice(d);
            return true;

        }
        return false;
    }
    public boolean chngCount(String s,int d)
    {
        product p=null;

        for(int i=0;i<subscribers.size();i++)
        {
            if(products.get(i).getName().equalsIgnoreCase(s))
            {
                p=products.get(i);
                break;
            }
        }
        if(p!=null)
        {
            p.changeCount(d);
            return true;

        }
        return false;
    }
    public boolean hasSubscription(subscriber sb,product p)
    {
        if(p.hasSubscriber(sb))
            return true;
        return false;
    }

}
