package decorateMeal;

import Meal.meal;

public class OnionRingsAndCoffee extends WithOnionRings{
    public OnionRingsAndCoffee(meal m)
    {
        super(m);
    }
    @Override
    public String prepareMeal() {
        return super.prepareMeal()+" and Coffee";
    }

    @Override
    public double price() {
        return super.price()+70.0;
    }
}
