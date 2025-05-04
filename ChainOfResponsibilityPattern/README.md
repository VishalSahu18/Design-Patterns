# Chain of Responsibility Design Pattern

**Definition:**

The Chain of Responsibility pattern allows an incoming request to be passed along a chain of handlers, where each handler can choose to process the request or pass it to the next handler in the chain.

**Explanation:**

Each object in the chain gets a chance to handle the request. If it can't, it passes it along.

📦 Real-life Analogy

Imagine you're escalating a complaint:

- First, it goes to a Customer Support Rep.
- If not resolved, it moves to a Manager.
- If still unresolved, it goes to the Director.

Each level has a chance to handle it.

**✅ Use Cases:**  
- Logging frameworks (INFO, DEBUG, ERROR)
- Event handling systems
- Servlet filters (in Java EE)
- Exception handling
- UI event bubbling

👨‍💻 **Java Implementation Example : Request Handler Chain (Authentication)**

**Handler Interface**

```java
public abstract class Handler {
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handleRequest(String request);
}
```

**Concrete Handlers**
```java
public class AuthHandler extends Handler {
    public void handleRequest(String request) {
        if (request.equals("auth")) {
            System.out.println("AuthHandler: Handling authentication.");
        } else if (next != null) {
            next.handleRequest(request);
        } else {
            System.out.println("AuthHandler: No handler found.");
        }
    }
}

public class LoggingHandler extends Handler {
    public void handleRequest(String request) {
        if (request.equals("log")) {
            System.out.println("LoggingHandler: Logging the request.");
        } else if (next != null) {
            next.handleRequest(request);
        } else {
            System.out.println("LoggingHandler: No handler found.");
        }
    }
}

public class ValidationHandler extends Handler {
    public void handleRequest(String request) {
        if (request.equals("validate")) {
            System.out.println("ValidationHandler: Validating the request.");
        } else if (next != null) {
            next.handleRequest(request);
        } else {
            System.out.println("ValidationHandler: No handler found.");
        }
    }
}
```

**Client Code**
```java
public class Main {
    public static void main(String[] args) {
        // Setup chain
        Handler auth = new AuthHandler();
        Handler log = new LoggingHandler();
        Handler validate = new ValidationHandler();

        auth.setNext(log);
        log.setNext(validate);

        // Send different requests
        auth.handleRequest("log");
        auth.handleRequest("validate");
        auth.handleRequest("auth");
        auth.handleRequest("unknown");
    }
}
```

**Output**
- LoggingHandler: Logging the request.
- ValidationHandler: Validating the request.
- AuthHandler: Handling authentication.
- ValidationHandler: No handler found.


**✅ Advantages**
- Decouples sender and receiver
- Follows Open/Closed Principle — new handlers can be added without changing existing code
- Flexible and dynamic request processing

**⚠️ Downsides**
- Can be hard to debug if chain gets too long
- There's no guarantee the request will be handled unless designed carefully

**🔄 Real-World Java Usage**
- Java Servlet Filters in web apps
- Spring Security Filter Chain
- Exception Handler chains
- Chain-of-responsibility middleware in frameworks
