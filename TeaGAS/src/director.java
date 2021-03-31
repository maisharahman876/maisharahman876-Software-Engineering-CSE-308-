public class director {
    productBuilder pb;
    Internet in;
    Framework fr;
    public void construct(productBuilder p, Internet i,Framework f)
    {
        pb=p;
        in=i;
        fr=f;
        pb.addMicroprocessor();
        pb.addWeightMeasurement();
        pb.addIdentification();
        pb.addStorage();
        pb.addDisplay();
        pb.addInternet(in);
        pb.addController();
        pb.addFramework(fr);

    }
}
