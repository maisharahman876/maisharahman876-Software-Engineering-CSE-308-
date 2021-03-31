public class PkgFactory {
    public  productBuilder getPkg(String s)
    {
        if(s.equalsIgnoreCase("silver"))
            return new silver();
        else if(s.equalsIgnoreCase("gold"))
            return new gold();
        else if(s.equalsIgnoreCase("platinum"))
            return new platinum();
        else if(s.equalsIgnoreCase("diamond"))
            return new diamond();
        else
        {
            System.out.println("Package not Found");
            return null;
        }


    }
    public  Internet getnet(String s)
    {
        if(s.equalsIgnoreCase("wi-fi"))
            return new Wifi();
        else if(s.equalsIgnoreCase("ethernet"))
            return new Ethernet();
        else if(s.equalsIgnoreCase("sim card"))
            return new GSM();
        else
        {System.out.println("Internet not Found");
            return null;
        }
    }
    public  Framework getFrame(String s)
    {
        if(s.equalsIgnoreCase("django"))
            return new Django();
        else if(s.equalsIgnoreCase("laravel"))
            return new Laravel();
        else if(s.equalsIgnoreCase("spring"))
            return new Spring();
        else
        {System.out.println("Internet not Found");
            return null;
        }
    }
}
