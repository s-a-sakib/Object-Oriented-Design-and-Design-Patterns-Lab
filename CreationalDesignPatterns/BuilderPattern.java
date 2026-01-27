// https://www.tutorialspoint.com/design_pattern/builder_pattern.htm

import java.util.ArrayList;
import java.util.List;

interface Item{
    public String name();
    public Packing packing();
    public float price();
}

interface Packing{
    public String pack();
}

class Wrapper implements Packing{
    @Override
    public String pack(){
          return "Wrapping";
    }
}

class Bottle implements Packing{
    @Override
    public String pack(){
          return "Packing";
    }
}

abstract class Burger implements Item{
    @Override
    public Packing packing(){
          return new Wrapper();
    }
    @Override
    public abstract float price();
}

abstract class ColdDrink implements Item{
    @Override
    public Packing packing(){
          return new Bottle();
    }
    @Override
    public abstract float price();
}
    
class VegBurger extends Burger{
    @Override
    public String name(){
          return "Veg Burger";
    }
    
    @Override 
    public float price(){
          return 20.5f;
    }
}

class ChickenBurger extends Burger{
    @Override
    public String name(){
          return "Chicken Burger";
    }
    
    @Override 
    public float price(){
          return 10.5f;
    }
}

class Pepsi extends ColdDrink{
    @Override
    public String name(){
          return "Pepsi";
    }
    
    @Override 
    public float price(){
          return 10.5f;
    }
}

class Coke extends ColdDrink{
    @Override
    public String name(){
          return "Coke";
    }
    
    @Override 
    public float price(){
          return 12.5f;
    }
}

class Meal{
    private List<Item> items = new ArrayList<Item>();
    
    public void addItem(Item item){
          items.add(item);
    }
    
    public float getCost(){
        float cost = 0.0f;
        for(Item item: items){
            cost += item.price();
        }
        return cost;
    }
    
    public void showItems(){
        for(Item item: items){
            System.out.print("Item : "+ item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.print(", Price : " + item.price());
            System.out.println("");
        }
    }
}

class MealBuilder {

   public Meal prepareVegMeal (){
      Meal meal = new Meal();
      meal.addItem(new VegBurger());
      meal.addItem(new Coke());
      return meal;
   }   

   public Meal prepareNonVegMeal (){
      Meal meal = new Meal();
      meal.addItem(new ChickenBurger());
      meal.addItem(new Pepsi());
      return meal;
   }
}

public class BuilderPattern{
   public static void main(String[] args) {
   
      MealBuilder mealBuilder = new MealBuilder();

      Meal vegMeal = mealBuilder.prepareVegMeal();
      System.out.println("Veg Meal");
      vegMeal.showItems();
      System.out.println("Total Cost: " + vegMeal.getCost());

      Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
      System.out.println("\n\nNon-Veg Meal");
      nonVegMeal.showItems();
      System.out.println("Total Cost: " + nonVegMeal.getCost());
   }
}

