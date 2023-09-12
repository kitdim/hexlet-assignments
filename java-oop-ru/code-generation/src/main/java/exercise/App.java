package exercise;

import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {


    public static void save(Path filepath, Car someCar) throws IOException {
        String content = someCar.serialize();
        Files.writeString(filepath, content, StandardOpenOption.WRITE);
    }

    public static Car extract(Path filepath) throws IOException {
        String content = Files.readString(filepath);
        return Car.unserialize(content);
    }
}
// END
