# Decorator Design Pattern

**Definition:**

The Decorator Pattern allows behavior to be added to an individual object, dynamically, without affecting the behavior of other objects from the same class.

**Explanation:**

Wrap an object with another object to add extra functionality.


📦 Real-life Analogy

Imagine a coffee shop:

- A basic coffee costs $5. 

You can decorate it with:

- milk (+$2)
- sugar (+$1)
- whipped cream (+$3)

Each decorator adds new functionality (cost, description).

**Key Components**
- Component : 	Common interface for all objects (e.g., Coffee)
- ConcreteComponent : 	The original object (e.g., SimpleCoffee)
- Decorator	: Abstract class that implements the component and holds a reference to a component
- ConcreteDecorator : 	Extends the decorator to add specific functionality

👨‍💻 **Java Implementation Example : Coffee Shop☕**

**Coffee Interface (Component)**

```java
public interface Coffee {
    String getDescription();
    double getCost();
}
```

**SimpleCoffee (ConcreteComponent)**

```java
public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}
```
**CoffeeDecorator (Abstract Decorator)**
```java
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}

```

**MilkDecorator and SugarDecorator (Concrete Decorators)**
```java
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }
}

```


**Client Code**
```java
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());
    }
}
```

**Output**  
- Simple Coffee $5.0
- Simple Coffee, Milk $7.0  
- Simple Coffee, Milk, Sugar $8.0   

**✅ Advantages of Decorator Pattern**  

- Follows Open/Closed Principle — add new functionality without changing existing code.
- Avoids class explosion from too many subclasses.
- Allows dynamic and flexible behavior at runtime.

**🔄 Common Use Cases**
- Java I/O Streams (BufferedReader, DataInputStream)
- GUI component libraries (adding scrollbars, borders)
- Logging, authentication, rate-limiting
- Spring Security filter chains
