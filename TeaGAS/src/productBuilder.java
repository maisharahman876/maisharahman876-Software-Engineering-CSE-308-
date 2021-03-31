public interface productBuilder {
    void addMicroprocessor();
    void addWeightMeasurement();
    void addIdentification();
    void addStorage();
    void addDisplay();
    void addInternet(Internet i);
    void addController();
    void addFramework(Framework f);
    product getProduct();

}
