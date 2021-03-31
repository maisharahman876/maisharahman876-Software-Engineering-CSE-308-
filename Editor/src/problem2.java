import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        while(true) {
            System.out.println("Enter your Sample File");
            Scanner sc = new Scanner(System.in);
            String l = sc.next();
            LangFActory factory = new LangFActory();
            Language lang = factory.getLang(l);
            if(lang==null)
                continue;
            editor builder=editor.getEditor();
            builder.build(lang);
            System.out.println();
        }
    }


}
