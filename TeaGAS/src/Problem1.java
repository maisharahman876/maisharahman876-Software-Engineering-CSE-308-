import java.util.Scanner;

public class Problem1
{
    public static void main(String[] args)
    {
          while(true) {
              System.out.println("Enter your Package choice:(Silver/Gold/Diamond/Platinum)");
              Scanner sc = new Scanner(System.in);
              String pkg = sc.nextLine();

              PkgFactory factory = new PkgFactory();
              productBuilder pr = factory.getPkg(pkg);
              if(pr==null)
                continue;
              System.out.println("Enter your Internet:(Wi-fi/Sim Card/Ethernet)");
              String net = sc.nextLine();
              Internet internet = factory.getnet(net);
              if(internet==null)
                  continue;
              System.out.println("Enter your FrameWork:(Django/Spring/Lareavel)");

              String f = sc.nextLine();
              Framework fr = factory.getFrame(f);
              if(fr==null)
                  continue;
              director d = new director();
              d.construct(pr, internet, fr);
              product p = pr.getProduct();
              p.show();
              break;
          }
    }
}