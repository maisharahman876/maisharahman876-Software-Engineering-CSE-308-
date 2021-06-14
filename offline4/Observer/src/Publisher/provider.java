package Publisher;

import Users.subscriber;

import java.util.Vector;

public class provider {
    Vector<subscriber> s1;
    String name;
    int stock_count;
    double price;

    provider(String a, int c, double d) {
        name = a;
        stock_count = c;
        price = d;
        s1 = new Vector<subscriber>();
    }
    public String getName()
    {
        return name;
    }

    void subscribe(subscriber s) {
        s1.add(s);

    }

    void unsubscribe(subscriber s) {
        s1.remove(s);

    }

    void sendNotification(String s) {
        for (int i=0;i<s1.size();i++)
        {
            s1.get(i).receive(s);
        }

    }

    public void increasePrice(double d)
    {
        price+=d;
        sendNotification("increased");//aro likha lgbe
    }
    public void decreasePrice(double d)
    {
        price-=d;
        sendNotification("decreased");//aro likha lgbe
    }
   public void changeCount(int c)
    {
        stock_count=c;
        sendNotification("changed");//aro likha lgbe
    }


}
