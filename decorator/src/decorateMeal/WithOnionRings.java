package decorateMeal;

import Meal.meal;

public class WithOnionRings extends MealDecorator{
    public WithOnionRings(meal m)
    {
        super(m);

    }

    @Override
    public String prepareMeal() {
        return super.prepareMeal()+" with Onion rings";
    }

    @Override
    public double price() {
        return super.price()+100.0;
    }
}
