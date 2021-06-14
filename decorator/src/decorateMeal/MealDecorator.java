package decorateMeal;

import Meal.meal;

public class MealDecorator implements meal {
    private meal m;
    public MealDecorator(meal m)
    {
        this.m=m;
    }

    @Override
    public double price() {
        return m.price();
    }

    @Override
    public String prepareMeal() {
        return m.prepareMeal();
    }
}
