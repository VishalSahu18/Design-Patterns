# Builder Design Pattern

**Definition:**

The Builder Pattern is used to construct a complex object step-by-step. It separates the construction of an object from its representation so that the same construction process can create different representations.

**Explanation:**

It lets you build an object in parts, using a fluent API or chained methods, especially when you have many fields or optional parameters.

📦 Real-life Analogy

Imagine you're building a Burger at a fast-food restaurant. You can choose:

- Bun ✅ / ❌
- Patty ✅ / ❌
- Cheese ✅ / ❌
- Sauce ✅ / ❌
- Veggies ✅ / ❌

Instead of creating multiple constructors or setters, you use a builder to pick only what you want.

✅ Use When:

- When constructors or factory methods become confusing (too many parameters).
- To build immutable objects (e.g., in Java records, DTOs).
- When you need a step-by-step construction process with optional fields.

👨‍💻 **Java Implementation Example : Building a User Profile**

**Target Class: User**

```java
public class User {
    // Required
    private final String username;
    private final String email;

    // Optional
    private final String phone;
    private final String address;

    private User(UserBuilder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    // Static Inner Builder Class
    public static class UserBuilder {
        private final String username;
        private final String email;

        private String phone;
        private String address;

        public UserBuilder(String username, String email) {
            this.username = username;
            this.email = email;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
```

**Client Code**

```java
public class Main {
    public static void main(String[] args) {
        User user = new User.UserBuilder("vishal_sahu", "vishal@example.com")
                .phone("1234567890")
                .address("Raipur, Chhattisgarh")
                .build();

        System.out.println(user);
    }
}
```

**🧾 Output::**  
User{username='vishal_sahu', email='vishal@example.com', phone='1234567890', address='Raipur, Chhattisgarh'}


**✅ Benefits**
- Readable and clean code, especially with many optional parameters.
- Eliminates need for telescoping constructors.
- Promotes immutability and encapsulation.
- Follows Single Responsibility Principle: the builder handles object creation logic.

**🔄 Common Use Cases in Java**
- StringBuilder
- Stream.Builder in Java 8
- Lombok @Builder (auto-generates builder pattern)
- Spring Boot configuration classes
- JSON/XML serialization frameworks like Jackson, Gson, JAXB



