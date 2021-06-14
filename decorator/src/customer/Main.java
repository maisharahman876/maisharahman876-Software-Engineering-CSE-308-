package customer;

import Meal.beefPizza;
import Meal.meal;
import Meal.veggiPizza;
import decorateMeal.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        while(true)
        {
            System.out.println("------Menu------");
            System.out.println("1. Beef Pizza with French Fry.");
            System.out.println("2. Veggi Pizza with Onion Rings.");
            System.out.println("3. Veggi Pizza with French Fry and coke.");
            System.out.println("4. Veggi Pizza with Onion Rings and Coffee.");
            System.out.println("5. Only Beef Pizza");
            System.out.println("Enter your choice: ");
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            if(choice==1)
            {
                MealDecorator m=new WithFrenchFry(new beefPizza());
                System.out.println("Preparing meal : "+m.prepareMeal());
                System.out.println("Price : "+m.price());
            }
            else if(choice==2)
            {
                MealDecorator m=new WithOnionRings(new veggiPizza());
                System.out.println("Preparing meal : "+m.prepareMeal());
                System.out.println("Price : "+m.price());
            }
            else if(choice==3)
            {
                MealDecorator m=new FrenchFryAndCoke(new veggiPizza());
                System.out.println("Preparing meal : "+m.prepareMeal());
                System.out.println("Price : "+m.price());
            }
            else if(choice==4)
            {
                MealDecorator m=new OnionRingsAndCoffee(new veggiPizza());
                System.out.println("Preparing meal : "+m.prepareMeal());
                System.out.println("Price : "+m.price());
            }
            else if(choice==5)
            {
                meal m=new beefPizza();
                System.out.println("Preparing meal : "+m.prepareMeal());
                System.out.println("Price : "+m.price());
            }
            else
                break;
        }
    }
}
