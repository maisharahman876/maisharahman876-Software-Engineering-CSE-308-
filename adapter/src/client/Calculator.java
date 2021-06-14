package client;

import java.io.*;
import java.util.Scanner;
//package client;
import Adapter.*;
import client.CalculateSum;

public class Calculator implements CalculateSum {
    SumAdapter adapter;
    int total=0;
    @Override

    public int sum(String typ, File f) throws Exception {
        File f1;
        if(typ.equalsIgnoreCase("int"))
        {
            f1=f;
        }
        else if(typ.equalsIgnoreCase("char"))
        {
            adapter=new SumAdapter(typ);
            f1=adapter.convert(f);
        }
        else
        {
            return 0;
        }
        Scanner sc=new Scanner(f1);
        int word;
        while(sc.hasNext())
        {
            word=sc.nextInt();
            total+=word;
        }

        return total;

    }
}
