# Open/Closed Principle (OCP)

**Definition:**

A class should be open for extension but closed for modification.

**Explanation:**

We should be able to extend a class's behavior without modifying its existing code. This prevents breaking existing functionality.

**Example (Violating OCP):**  

```java
class PaymentProcessor {
    public void processPayment(String paymentType) {
    
        if (paymentType.equals("CreditCard")) {
            // Process credit card payment
        } else if (paymentType.equals("PayPal")) {
            // Process PayPal payment
        }
    }
}

```

**What's wrong?**

Every time a new payment method is added (e.g., Google Pay), we need to modify the class.
Following OCP with Polymorphism


**Correct Approach**
Following OCP with Polymorphism

```java
 interface PaymentMethod {
    void pay();
}

class CreditCardPayment implements PaymentMethod {
    public void pay() {
        System.out.println("Processing Credit Card payment...");
    }
}

class PayPalPayment implements PaymentMethod {
    public void pay() {
        System.out.println("Processing PayPal payment...");
    }
}

class PaymentProcessor {
    public void processPayment(PaymentMethod paymentMethod) {
        paymentMethod.pay();
    }
}

```

**Why is this better?**

We can add new payment methods without modifying existing code.  
The system is more extensible.  

**What happens if we don’t follow OCP?**

🔴 Frequent Modifications → Every time we add a feature, we modify existing code.  
🔴 Higher Risk of Bugs → Changes may break the existing functionality.  
🔴 Hard to Scale → Extending functionality is painful.  

**Benefits of OCP**

✅ Easier feature addition → New features can be added without modifying old code.  
✅ Less risk of bugs → Existing functionality remains untouched.  
✅ More flexible code → Code can evolve over time.  



