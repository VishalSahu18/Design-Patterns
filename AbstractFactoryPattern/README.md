# Abstract Factory Design Pattern

**Definition:**

The Abstract Factory Pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

**Explanation:**

It's a factory of factories. It produces multiple related objects from multiple concrete factories — all without the client knowing the specific classes involved.

📦 Real-life Analogy

Imagine a Furniture Factory that can produce:
- Modern Chair, Modern Sofa
- Victorian Chair, Victorian Sofa

You want to be able to switch the whole furniture family (modern/victorian) without changing the way you create them.

✅ Use When:

- You want to create families of related objects.
- You want to switch between families easily.
- You want to abstract the object creation process even further than Factory Pattern.

👨‍💻 **Java Implementation Example : GUI Toolkit (Windows & Mac) 🎨**

**Product Interface**

```java
public interface Button {
    void render();
}

public interface Checkbox {
    void render();
}

```

**Concrete Products: Windows and Mac Variants**

```java
// Windows Variants
public class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

public class WindowsCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering Windows Checkbox");
    }
}

// Mac Variants
public class MacButton implements Button {
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}

public class MacCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering Mac Checkbox");
    }
}
```

**Abstract Factory Interface**
```java
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
```

**Concrete Factories**
```java
public class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

public class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

```

**Client Code**
```java
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.render();
        checkbox.render();
    }
}
```

**Main App Entry Point**
```java
public class Main {
    public static void main(String[] args) {
        GUIFactory factory;

        // Assume platform is Windows
        factory = new WindowsFactory();
        // For Mac, just switch to: factory = new MacFactory();

        Application app = new Application(factory);
        app.renderUI();
    }
}
```

**Output (for WindowsFactory):**
- Rendering Windows Button
- Rendering Windows Checkbox

**✅ Advantages**
- Easily switch between families (e.g., Windows ↔ Mac).
- Promotes consistency across related objects.
- Fully decouples client code from concrete implementations.

**🔄 Common Use Cases**
- GUI libraries (Swing, AWT, JavaFX)
- Dependency Injection frameworks (Spring Beans)
- Theme-based components (DarkThemeFactory, LightThemeFactory)
- Multi-database systems (MySQLFactory, OracleFactory)

