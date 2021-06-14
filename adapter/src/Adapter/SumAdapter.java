package Adapter;

import java.io.File;
//package Adapter;
import DataType.*;
public class SumAdapter {
    Type t;
    public SumAdapter(String typ)
    {
        if(typ.equalsIgnoreCase("char"))
            t=new Char();

    }

    public File convert(File f)
    {
        File f1=t.change(f);
        return  f1;
    }
}
