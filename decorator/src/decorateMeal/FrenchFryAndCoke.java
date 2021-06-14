package decorateMeal;

import Meal.meal;

public class FrenchFryAndCoke extends WithFrenchFry{

    public FrenchFryAndCoke(meal m) {
        super(m);
    }

    @Override
    public String prepareMeal() {
        return super.prepareMeal()+" and Coke";
    }

    @Override
    public double price() {
        return super.price()+20.0;
    }
}
