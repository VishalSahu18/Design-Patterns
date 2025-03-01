# Dependency Inversion Principle (DIP)

**Definition:**

High-level modules should not depend on low-level modules. Both should depend on abstractions.

**Explanation:**

Instead of tightly coupling classes, depend on interfaces or abstract classes.

**Example (Violating DIP):**

```java
class MySQLDatabase {
    public void connect() {
        System.out.println("Connecting to MySQL...");
    }
}

class Application {
    private MySQLDatabase database;

    public Application() {
        this.database = new MySQLDatabase();
    }

    public void start() {
        database.connect();
    }
}
```
**What's wrong?**

Application is tightly coupled with MySQLDatabase. Changing to another database (e.g., PostgreSQL) requires modifying Application.

**Correct Approach (Following ISP):**


```java
interface Database {
    void connect();
}

class MySQLDatabase implements Database {
    public void connect() {
        System.out.println("Connecting to MySQL...");
    }
}

class PostgreSQLDatabase implements Database {
    public void connect() {
        System.out.println("Connecting to PostgreSQL...");
    }
}

class Application {
    private Database database;

    public Application(Database database) {
        this.database = database;
    }

    public void start() {
        database.connect();
    }
}
```

**Why is this better?**

Application depends on the Database interface, making it flexible for different databases.


**What happens if we don’t follow DIP?**

🔴 Tightly Coupled Code → High-level classes depend on low-level classes directly.  
🔴 Hard to Swap Implementations → Changing a dependency requires modifying multiple files.  
🔴 Difficult Testing → Hard to mock dependencies for unit tests.  

**Benefits of DIP**

✅ Easier to swap dependencies → Use different implementations without changing core logic.  
✅ Better testability → Use mock objects for unit testing.  
✅ More maintainable → Changes in one module don’t affect others.  


