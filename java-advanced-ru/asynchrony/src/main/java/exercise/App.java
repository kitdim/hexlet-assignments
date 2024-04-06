package exercise;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1,
                                                       String file2,
                                                       String file3) {
        CompletableFuture<String> futureReadFirstFile = CompletableFuture.supplyAsync(() -> {
            try {
                var path = Path.of(file1);
                return Files.readString(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> futureReadSecondFile = CompletableFuture.supplyAsync(() -> {
            try {
                var path = Path.of(file2);
                return Files.readString(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return futureReadFirstFile.thenCombine(
                futureReadSecondFile, (firstValue, secondValue) -> {
                    try {
                        var resultPath = Path.of(file3);
                        var resultValue = firstValue + " " + secondValue;
                        Files.writeString(resultPath, resultValue);
                        return resultValue;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return ex.getMessage();
        });
    }
     // END

    public static void main(String[] args) throws Exception {
        // BEGIN

        // END
    }
}

