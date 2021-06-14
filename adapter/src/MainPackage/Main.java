package MainPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//package MainPackage;
import client.Calculator;

public class Main {
    public static void main(String[] args) throws Exception {
        Calculator cal=new Calculator();
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the file path:");
        String file=sc.next();
        File f=new File(file+".txt");
        System.out.println("Enter the type of your input format:");
        String typ=sc.next();
        int total= 0;
        try {
            total = cal.sum(typ,f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("The total Sum is "+total);
    }
}
