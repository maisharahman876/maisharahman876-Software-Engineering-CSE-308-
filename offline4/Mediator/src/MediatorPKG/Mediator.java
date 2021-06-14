package MediatorPKG;

import Organizations.*;

public interface Mediator {
    public void collaborate(Organization d, Organization r, Organization w, Organization t);
    //public void notification(Organization o);
    public void react_on_request(Organization o,String s);
    public void receive(Organization o);
}
