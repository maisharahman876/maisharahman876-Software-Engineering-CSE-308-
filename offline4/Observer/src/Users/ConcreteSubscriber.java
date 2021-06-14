package Users;

import java.util.Vector;

public class ConcreteSubscriber implements subscriber{

    String name;
    Vector<String> v1;
    public ConcreteSubscriber(String n)
    {
        name=n;
        v1=new Vector<>();
    }
    public String getName()
    {
        return name;
    }
    @Override
    public void update() {
        for(int i=0;i<v1.size();i++)
        {
            System.out.println(v1.get(i));

        }
        v1.clear();


    }

    @Override
    public void receive(String s) {
        v1.add(s);
    }
}
