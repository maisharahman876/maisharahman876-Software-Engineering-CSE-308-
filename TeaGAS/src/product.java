public class product {
    Microprocessor m;
    WeightMeasure w;
    Identification i;
    Storage s;
    Display d;
    Controller c;
    Internet in;
    Framework f;
    public product()
    {
        m=null;
        w=null;
        i=null;
        in=null;
        s=null;
        d=null;
        c=null;
        f=null;

    }
    public void setprocessor(Microprocessor m1)
    {
      m=m1;
    }
    public void setWeightMeasurement(WeightMeasure w1)
    {
        w=w1;

    }
    public void setIdentification(Identification i1)
    {
        i=i1;
    }
    public void setStorage(Storage s1)
    {
        s=s1;
    }
    public void setDisplay(Display d1)
    {
        d=d1;
    }
    public void setControl(Controller c1) {
        c = c1;
    }
    public void setInternet(Internet in1)
    {
        in=in1;
    }
    public void setFrame(Framework f1)
    {
        f=f1;
    }
    public void show()
    {
        System.out.println("Taking "+m.name()+" as Microprocessor");
        System.out.println("Measuring weight with "+w.name());
        System.out.println("Using "+i.name()+" for Identification");
        if(s!=null)
        System.out.println("Using "+s.name()+" for externel storage");
        else
            System.out.println("There is no externel storage needed");
        System.out.println("Using "+d.name()+" for Display");
        if(c!=null)
            System.out.println("Using "+c.name()+" as Controller");
        else
            System.out.println("There is no Controller needed");
        if(in!=null)
            System.out.println("Using "+in.name()+" for Internet Connection");
        else
            System.out.println("You haven't Select an proper Internet");

        if(f!=null)
            System.out.println("Using "+f.name()+"for FrameWork");
        else
            System.out.println("You Haven't Select a FrameWork");

    }


}
