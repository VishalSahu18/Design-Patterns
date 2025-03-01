# Interface Segregation Principle (ISP)

**Definition:**

A class should not be forced to implement interfaces it does not use.

**Explanation:**

A single large interface should be broken down into smaller, more specific interfaces.

**Example (Violating ISP):**

```java
interface Worker {
    void work();
    void eat();
}

class Developer implements Worker {
    public void work() {
        System.out.println("Writing code...");
    }

    public void eat() {
        System.out.println("Eating lunch...");
    }
}

class Robot implements Worker {
    public void work() {
        System.out.println("Performing automated tasks...");
    }

    public void eat() {
        // Robots don't eat!
        throw new UnsupportedOperationException("Robots don't eat!");
    }
}

```
**What's wrong?**

The Robot class is forced to implement eat(), which it does not need.

**Correct Approach (Following ISP):**


```java
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Developer implements Workable, Eatable {
    public void work() {
        System.out.println("Writing code...");
    }

    public void eat() {
        System.out.println("Eating lunch...");
    }
}

class Robot implements Workable {
    public void work() {
        System.out.println("Performing automated tasks...");
    }
}

```

**Why is this better?**  

Classes only implement the methods they actually need.


**What happens if we don’t follow ISP?**  

🔴 Unnecessary Implementations → Classes are forced to implement methods they don’t use.  
🔴 Code Breaks Easily → Any change in the interface affects all classes.  
🔴 Difficult Maintenance → More changes required when modifying an interface.  

**Benefits of ISP**  
✅ Less impact of changes → Only relevant classes are affected.  
✅ Easier to understand → Each interface is smaller and more focused.  
✅ More flexible code → Different parts of the system evolve independently.  

