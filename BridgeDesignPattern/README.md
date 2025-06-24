# Bridge Design Pattern

**Definition:**

The Bridge Pattern decouples an abstraction from its implementation so that the two can vary independently.

**Explanation:**

It's like plugging different types of remotes (abstractions) into different TVs (implementations) — both can evolve separately.


📦 Real-life Analogy  
Think of a TV Remote Control:

- You have different remotes (basic, advanced).
- They can work with different brands of TVs (Sony, Samsung).
- Remotes and TVs evolve independently, yet work together.
- 
✅ Use Case
- You want to avoid a class explosion (e.g., RedCircle, GreenCircle, RedSquare, GreenSquare, etc.).
- You want to separate abstraction and implementation.
- You want to make both extensible without modifying each other.

👨‍💻 **Java Implementation Example :  Drawing Shapes with Different Renderers**

**Implementor Interface**

```java
public interface Renderer {
    void render(String shapeName);
}
```

**Concrete Implementations**
```java
public class VectorRenderer implements Renderer {
    public void render(String shapeName) {
        System.out.println("Drawing " + shapeName + " as lines");
    }
}

public class RasterRenderer implements Renderer {
    public void render(String shapeName) {
        System.out.println("Drawing " + shapeName + " as pixels");
    }
}
```

**Abstraction (Shape)**
```java
public abstract class Shape {
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
}
```

**Refined Abstraction (e.g., Circle)**
```java
public class Circle extends Shape {
    public Circle(Renderer renderer) {
        super(renderer);
    }

    public void draw() {
        renderer.render("Circle");
    }
}
```

**Client Code**
```java
public class Main {
    public static void main(String[] args) {
        Shape circle1 = new Circle(new VectorRenderer());
        circle1.draw(); // Output: Drawing Circle as lines

        Shape circle2 = new Circle(new RasterRenderer());
        circle2.draw(); // Output: Drawing Circle as pixels
    }
}
```

**Output**
- Drawing Circle as lines  
- Drawing Circle as pixels



**✅ Benefits of Bridge Pattern**

- Separates concerns: abstraction vs. implementation.
- Makes it easy to extend both dimensions independently.
- Avoids subclass explosion: Instead of 5 shapes × 5 renderers = 25 subclasses, you have only 5 shapes and 5 renderers.

**🔄 Real-World Java Usage**

- JDBC API: Connection is the abstraction; actual DB drivers (MySQLDriver, OracleDriver) are implementations.
- Spring AOP uses bridge-like behavior to decouple advice (abstraction) and invocation (implementation).
- GUI frameworks: different toolkits for rendering the same components.


