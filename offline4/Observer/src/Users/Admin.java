package Users;

public class Admin implements subscriber{
    String name;
    public Admin()
    {
        name="Admin";
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update() {

    }

    @Override
    public void receive(String s) {

    }
}
