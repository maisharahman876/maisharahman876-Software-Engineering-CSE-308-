public class LangFActory {
    public Language getLang(String s)
    {

        if(s.endsWith(".py"))
            return new Python();
        else if(s.endsWith(".c"))
            return new C();
        else if (s.endsWith(".cpp"))
            return new CPP();
        else
        {
            System.out.println("This Extension not found");
            return null;
        }

    }

}
