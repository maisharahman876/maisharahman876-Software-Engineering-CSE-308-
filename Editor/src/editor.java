public class editor {
    private static editor instance=null;
    Language l;
    public void build(Language l1)
    {
        l=l1;
        l.parse();
        l.addFont();
        l.addColor();
        l.addStyle();


    }
    public static editor getEditor()
    {
        if(instance==null)
            instance=new editor();
        return instance;
    }
}
