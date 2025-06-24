# Facade Design Pattern

**Definition:**

The Facade Pattern provides a simplified interface to a larger subsystem of classes, hiding its complexities and making it easier to use.

**Explanation:**

It’s like a front desk at a hotel: You don’t talk to housekeeping, kitchen, or valet directly. You talk to one person (the facade) who handles everything for you.


📦 Real-life Analogy

Think of a Home Theater System:

- You have DVD player, projector, sound system, lights, etc.
- The Facade can be a RemoteControl with methods like watchMovie() and endMovie() that coordinate all subsystems.

✅ Use Case

- When you want to hide complex subsystems from the client.
- When you want to provide a simple API for a complicated library or framework.
- When dealing with legacy systems.

👨‍💻 **Java Implementation Example : Home Theater Facade**

**Subsystem Classes**

```java
public class DVDPlayer {
    public void on() { System.out.println("DVD Player ON"); }
    public void play(String movie) { System.out.println("Playing movie: " + movie); }
    public void off() { System.out.println("DVD Player OFF"); }
}

public class Projector {
    public void on() { System.out.println("Projector ON"); }
    public void setMode(String mode) { System.out.println("Projector set to " + mode + " mode"); }
    public void off() { System.out.println("Projector OFF"); }
}

public class SurroundSoundSystem {
    public void on() { System.out.println("Surround Sound ON"); }
    public void setVolume(int level) { System.out.println("Volume set to " + level); }
    public void off() { System.out.println("Surround Sound OFF"); }
}
```

**Facade Class**

```java
public class HomeTheaterFacade {
    private DVDPlayer dvd;
    private Projector projector;
    private SurroundSoundSystem sound;

    public HomeTheaterFacade(DVDPlayer dvd, Projector projector, SurroundSoundSystem sound) {
        this.dvd = dvd;
        this.projector = projector;
        this.sound = sound;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        projector.on();
        projector.setMode("Widescreen");
        sound.on();
        sound.setVolume(10);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down theater...");
        dvd.off();
        projector.off();
        sound.off();
    }
}
```
**Client Code**
```java
public class Main {
    public static void main(String[] args) {
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        SurroundSoundSystem sound = new SurroundSoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, projector, sound);

        homeTheater.watchMovie("Inception");
        System.out.println();
        homeTheater.endMovie();
    }
}
```

**Output**  

Get ready to watch a movie...  
Projector ON  
Projector set to Widescreen mode  
Surround Sound ON  
Volume set to 10  
DVD Player ON  
Playing movie: Inception  

Shutting down theater...  
DVD Player OFF  
Projector OFF  
Surround Sound OFF  


**✅ Benefits of Facade Pattern**

- Simplifies complex subsystem usage for the client.
- Promotes loose coupling between client and subsystems.
- Improves readability and maintainability.
- Encapsulates interaction logic.

**🔄 Real-World Examples in Java**

- javax.faces.context.FacesContext in Java EE
- java.util.logging.Logger hides log handling internals
- Spring's JdbcTemplate, RestTemplate, etc.
- Apache Commons FileUtils, IOUtils


