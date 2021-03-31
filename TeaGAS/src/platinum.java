public class platinum implements productBuilder{
    private product p;
    platinum()
    {
        p= new product();
    }
    public void addMicroprocessor() {
        Microprocessor m=new RaspberryPi();
        p.setprocessor(m);
    }
    public void addWeightMeasurement()
    {
        WeightMeasure w=new Weight_Module();
        p.setWeightMeasurement(w);
    }
    public void addIdentification()
    {
        Identification i=new NFC();
        p.setIdentification(i);
    }
    public void addStorage()
    {
        Storage s=null;
        p.setStorage(s);
    }
    public void addDisplay()
    {
        Display d=new Touch_Screen();
        p.setDisplay(d);
    }
    public void addController()
    {
        Controller c=null;
        p.setControl(c);
    }
    public void addInternet(Internet i)
    {
        p.setInternet(i);
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
