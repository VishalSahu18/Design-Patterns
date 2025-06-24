# Proxy Design Pattern

**Definition:**

The Proxy Design Pattern provides a surrogate or placeholder for another object to control access to it.

**Explanation:**

Instead of calling the real object directly, you go through a proxy, which can:
- Control access
- Add extra functionality
- Delay object creation (lazy initialization)
- Cache results, log actions, enforce security, etc.

📦 Real-life Analogy

Imagine a celebrity (Real Object) who doesn’t deal with people directly. A manager (Proxy) handles calls and meetings for them — allowing only valid requests through.

**✅ Types of Proxies:**
- ***Virtual Proxy*** – Delays object creation until needed (lazy loading)
- ***Protection Proxy*** – Controls access (e.g., user roles, security)
- ***Remote Proxy*** – Manages access to an object in a different address space (e.g., RMI)
- ***Smart Proxy*** – Adds additional logic (e.g., logging, caching)

👨‍💻 **Java Implementation Example : Protection Proxy (Access Control)**

**Subject Interface**

```java
public interface Internet {
    void connectTo(String site) throws Exception;
}
```

**Real Object**
```java
public class RealInternet implements Internet {
    public void connectTo(String site) {
        System.out.println("Connecting to " + site);
    }
}
```

**Proxy Class**
```java
import java.util.*;

public class ProxyInternet implements Internet {
    private Internet realInternet = new RealInternet();
    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<>();
        bannedSites.add("facebook.com");
        bannedSites.add("youtube.com");
    }

    public void connectTo(String site) throws Exception {
        if (bannedSites.contains(site.toLowerCase())) {
            throw new Exception("Access Denied to " + site);
        }
        realInternet.connectTo(site);
    }
}
```

**Client Code**
```java
public class Main {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();

        try {
            internet.connectTo("geeksforgeeks.org");
            internet.connectTo("facebook.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
```

**Output**
- Connecting to geeksforgeeks.org
- Access Denied to facebook.com

**✅ Advantages**
- Adds security, caching, logging, or other cross-cutting concerns without modifying the real object.
- Follows Open/Closed Principle — add behavior without changing the core object.
- Supports lazy loading (used in ORM like Hibernate).

**🔄 Real-World Java Usage**
- Spring AOP: Proxies are used to apply cross-cutting concerns like logging, transactions.
- Hibernate: Uses proxies for lazy loading entities.
- Java RMI: Remote proxies to access objects over the network.
- Service Layer Security: Restrict access using proxies.