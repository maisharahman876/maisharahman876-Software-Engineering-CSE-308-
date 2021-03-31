public class silver implements productBuilder{
    private product p;
    silver()
    {
      p= new product();
    }
    public void addMicroprocessor() {
        Microprocessor m=new ATMega32();
        p.setprocessor(m);
    }
    public void addWeightMeasurement()
    {
        WeightMeasure w=new Load_Sensor();
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
        Display d=new LED();
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
