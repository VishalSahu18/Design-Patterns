# Strategy Design Pattern

**Definition:**

The Strategy Pattern is a behavioral design pattern that lets you define a family of algorithms, put each of them in a separate class, and make their objects interchangeable.

**Explanation:**

It helps you select the algorithm (or behavior) at runtime instead of hardcoding it.

📦 Real-life Analogy  
Think of a navigation app. It can give you directions:

by car  
by bike  
by walking  

All are strategies for finding a route.

✅ Structure  
Strategy Interface – common behavior  
Concrete Strategies – different implementations  
Context – uses a Strategy

**Strategy Interface**

```java
public interface PaymentStrategy {
    void pay(int amount);
}
```

**Concrete Strategies**
```java
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card: " + cardNumber);
    }
}

public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using PayPal: " + email);
    }
}

```
**Context**
```java
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Inject strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}
```

**Client Code**
```java
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay using Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(500);

        // Pay using PayPal
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(800);
    }
}

```