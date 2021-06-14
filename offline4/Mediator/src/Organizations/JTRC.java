package Organizations;

import MediatorPKG.Mediator;

public class JTRC implements Organization{
    Mediator m;
    int reqs;
    public JTRC(Mediator m1)
    {
        m=m1;
        reqs=0;
    }
    @Override
    public void request(String s) {
        System.out.println("JTRC requests for "+s+" service");
        m.react_on_request(this,s);
    }
    @Override
    public void addReq() {
        reqs++;
    }
    public void serve() {
        if(reqs>0)
        {
            reqs--;
            m.receive(this);
        }
        else
            System.out.println("No more requests");
    }

    @Override
    public String toString() {
        return "JTRC";
    }
}
