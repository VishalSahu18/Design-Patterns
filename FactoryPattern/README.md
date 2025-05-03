# Factory Design Pattern

**Definition:**

The Factory Design Pattern provides an interface for creating objects, but allows subclasses to alter the type of objects that will be created.

**Explanation:**

Don’t use *new* objects directly — instead, delegate the object creation to a factory class.

📦 Real-life Analogy

Imagine a Vehicle Factory:
- You give the factory a vehicle type: "car" or "bike".
- It gives you the right object: Car or Bike — you don’t need to know how it's built.


👨‍💻 **Java Implementation Example : Shape Factory 🎨**

**Product Interface**

```java
public interface Shape {
    void draw();
}
```

**Concrete Implementation**

```java
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}
```

**Factory Class**
```java
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) return null;

        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }

        return null;
    }
}
```

**Client Code**
```java
public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
    }
}

```

**Output**
- Drawing Circle
- Drawing Rectangle


✅ Benefits of Factory Pattern
- Encapsulates object creation logic
- Promotes loose coupling and polymorphism 
- Follows Open/Closed Principle — add new shapes without modifying the factory method heavily

🔄 Common Use Cases
- JDBC: DriverManager.getConnection()
- Spring: ApplicationContext.getBean()
- Logging frameworks: LoggerFactory.getLogger()
- UI toolkit: creating platform-specific components

