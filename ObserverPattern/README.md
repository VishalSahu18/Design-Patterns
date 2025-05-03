# Observer Design Pattern

**Definition:**

The Observer Design Pattern defines a one-to-many dependency between objects so that when one object (Subject) changes state, all its dependents (Observers) are notified and updated automatically.

**Explanation:**

When something changes, notify everyone who is watching it.


📦 Real-life Analogy  

Think of a YouTube Channel:

- The channel is the subject.

- The subscribers are the observers.

- When the channel uploads a new video, all subscribers get a notification.

👨‍💻 **Java Implementation Example**  

Let’s build a simple notification system for a weather station:


**Observer Interface**

```java
public interface Observer {
    void update(float temperature, float humidity);
}

```

**Subject Inteface**
```java
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

```
**Concrete Subject: WeatherStation**
```java
import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature, humidity);
        }
    }

    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers(); // Notify on state change
    }
}
```

**Concrete Observer: PhoneDisplay**
```java
public class PhoneDisplay implements Observer {
    private String name;

    public PhoneDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature, float humidity) {
        System.out.println(name + " - New Weather Update => Temp: " + temperature + ", Humidity: " + humidity);
    }
}
```

**Concrete Observer: PhoneDisplay**
```java
public class TvDisplay implements Observer {
    
    private String name;

    public TvDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature, float humidity) {
        System.out.println(name + " - New Weather Update => Temp: " + temperature + ", Humidity: " + humidity);
    }
}
```

**Client Code**
```java
public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        PhoneDisplay phone1 = new PhoneDisplay("Alice's Phone");
        PhoneDisplay phone2 = new PhoneDisplay("Bob's Phone");
        TvDisplay tv1 = new PhoneDisplay("Alice's TV");

        station.registerObserver(phone1);
        station.registerObserver(phone2);
        station.registerObserver(tv1);
        

        station.setMeasurements(30.5f, 65f);  // all observers get notified
        station.removeObserver(phone1);
        station.removeObserver(tv1);
        station.setMeasurements(32f, 70f);    // Only Bob gets notified
        
    }
}

```