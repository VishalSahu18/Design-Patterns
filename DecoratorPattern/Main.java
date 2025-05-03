package DecoratorPattern;

import DecoratorPattern.decorator.ExtraCheese;
import DecoratorPattern.decorator.Mushroom;
import DecoratorPattern.model.BasePizza;
import DecoratorPattern.model.Margherita;

public class Main {

    public static void main(String[] args) {
        BasePizza pizza1 = new Mushroom(new ExtraCheese(new Margherita()));
        System.out.println(pizza1.cost());
    }
}
