package decorateMeal;

import Meal.meal;

public class WithFrenchFry extends MealDecorator {
    public WithFrenchFry(meal m)
    {
        super(m);

    }

    @Override
    public String prepareMeal() {
        return super.prepareMeal()+" with French Fry";
    }

    @Override
    public double price() {
        return super.price()+100.0;
    }
}
