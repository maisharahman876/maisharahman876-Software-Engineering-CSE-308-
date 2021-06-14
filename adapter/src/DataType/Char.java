package DataType;

import java.io.*;
import java.util.Scanner;

//package DataType;
public class Char implements Type{
    @Override
    public File change(File f) {
        File f1=new File("output.txt");
        try {
            boolean newFile = f1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //change file elements
        try {

            Scanner sc=new Scanner(f);
            try (Writer fw = new FileWriter(f1)) {
                while (sc.hasNext())
                {
                    String s=sc.next();
                    char ch=s.charAt(0);

                    int ascii=(int)ch;
                    fw.write(String.valueOf(ascii));
                    fw.write(" ");

                }
                fw.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return f1;
    }
}
