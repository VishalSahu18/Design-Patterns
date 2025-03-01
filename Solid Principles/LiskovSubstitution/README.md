**Liskov Substitution Principle (LSP)**

**Definition:**

A subclass should be substitutable for its base class without affecting program correctness.  

OR

If Class B is subtype of Class A, then we should be able to replace object A with B without breaking the behaviour of the program.  

**Explanation:**

A subclass should extend the behavior of a parent class without changing its original meaning.

**Example (Violating LSP):**
```java
class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!");
    }
}

```
**What's wrong?**

The subclass (Penguin) violates the expectation that all birds can fly.

**Correct Approach (Following LSP)**  

```java
abstract class Bird { }

class FlyingBird extends Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

class Penguin extends Bird {
    public void swim() {
        System.out.println("Swimming...");
    }
}

```

**Why is this better?**

Now, Penguin is not forced to implement fly(), maintaining the correct behavior.


**What happens if we don’t follow LSP?**

🔴 Unexpected Behavior → A subclass behaves differently than expected.  
🔴 Code Breaks → Functions using a base class may not work with a subclass.  
🔴 Hard to Debug → The wrong behavior may be hidden inside the subclass.  

**Benefits of LSP**

✅ More reliable code → Subclasses behave correctly when used as base classes.  
✅ Fewer bugs → The program won’t break due to unexpected subclass behavior.  
✅ Easier to extend → We can add new types safely.  
