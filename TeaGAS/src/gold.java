public class gold implements productBuilder{
    private product p;
    gold()
    {
        p= new product();
    }
    public void addMicroprocessor() {
        Microprocessor m=new Arduino();
        p.setprocessor(m);
    }
    public void addWeightMeasurement()
    {
        WeightMeasure w=new Weight_Module();
        p.setWeightMeasurement(w);
    }
    public void addIdentification()
    {
        Identification i=new RFID();
        p.setIdentification(i);
    }
    public void addStorage()
    {
        Storage s=new SD_Card();
        p.setStorage(s);
    }
    public void addDisplay()
    {
        Display d=new LCD();
        p.setDisplay(d);
    }
    public void addController()
    {
        Controller c=new Button();
        p.setControl(c);
    }
    public void addInternet(Internet i)
    {
        if(i.name().equalsIgnoreCase("ethernet"))
        {
            System.out.println("This Package don't support this type of Internet");
        }
        else
        {
            p.setInternet(i);
        }
    }
    public void addFramework(Framework f)
    {
        p.setFrame(f);
    }
    public product getProduct()
    {
        return p;
    }
}
