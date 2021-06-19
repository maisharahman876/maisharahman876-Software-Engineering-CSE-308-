package stock;

import Users.subscriber;

import java.util.Vector;

public class product {
    Vector<subscriber> s1;
    String name;
    int stock_count;
    double price;

   public product(String a, int c, double d) {
        name = a;
        stock_count = c;
        price = d;
        s1 = new Vector<subscriber>();
    }
    public String getName()
    {
        return name;
    }

    public int subscribe(subscriber s) {
       if(!s1.contains(s)) {
           s1.add(s);
           return 1;
       }
       return 0;
    }
    public  boolean hasSubscriber(subscriber s)
    {
       for(int i=0;i<s1.size();i++)
       {
           if(s.getName().equalsIgnoreCase(s1.get(i).getName()))
               return true;
       }
       return false;
    }
    public int unsubscribe(subscriber s) {
        if(s1.contains(s)) {

            s1.remove(s);
            return 1;
        }
        return 0;

    }


    public void increasePrice(double d)
    {
        price+=d;
        //sendNotification("increased");//aro likha lgbe
    }
    public void decreasePrice(double d)
    {
        price-=d;
       // sendNotification("decreased");//aro likha lgbe
    }
   public void changeCount(int c)
    {
        stock_count=c;
       // sendNotification("changed");//aro likha lgbe
    }

    @Override
    public String toString() {
        return name+" "+stock_count+" "+price;
    }
}
