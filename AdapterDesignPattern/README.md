# Adapter Design Pattern

**Definition:**

The Adapter Pattern allows incompatible interfaces to work together. It converts the interface of a class into another interface that the client expects.

**Explanation:**

You use an Adapter when you want to connect a plug (object) into a socket (interface) that doesn't fit — by writing a middle layer (adapter) that makes them compatible.

**📦 Real-life Analogy**

You have a 3-pin laptop charger, but the wall socket only supports 2-pin plugs. You use a 3-to-2 pin adapter so they can connect.

**✅ Use Case:**
When you have existing classes (e.g., legacy or third-party) that don't match your interface, and you can't or don’t want to modify them.
Bridging old code with new interfaces.

👨‍💻 **Java Implementation Example : Media Player Adapter**

**Target Interface (Client expects this)**

```java
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
```

**Adaptee Interfaces (Incompatible classes)**
```java
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}
```

**Concrete Adaptees**
```java
public class VlcPlayer implements AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }

    public void playMp4(String fileName) {
        // Do nothing
    }
}

public class Mp4Player implements AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        // Do nothing
    }

    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}
```

**Adapter Class**
```java
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
```

**Client Class**
```java
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media format: " + audioType);
        }
    }
}
```

**Demo (Main Class)**
```java
public class Main {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "song1.mp3");
        player.play("vlc", "movie1.vlc");
        player.play("mp4", "clip1.mp4");
        player.play("avi", "unknown.avi");
    }
}
```

**Output**
- Playing MP3 file: song1.mp3
- Playing VLC file: movie1.vlc
- Playing MP4 file: clip1.mp4
- Invalid media format: avi

**✅ Advantages**
- Reuse existing incompatible classes without modifying them.
- Promotes flexibility and reusability.
- Follows Open/Closed Principle — you can extend capabilities without altering original code.

**🔄 Real-World Java Usage**
- java.util.Arrays#asList() acts as an adapter from array to List.
- java.io.InputStreamReader: adapts InputStream to Reader.
- Spring Adapter classes: like HandlerAdapter in Spring MVC.