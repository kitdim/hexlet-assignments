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
        return CompletableFuture.supplyAsync(() -> {
            try {
                String content1 = new String(Files.readAllBytes(Paths.get(file1)));
                String content2 = new String(Files.readAllBytes(Paths.get(file2)));

                String combinedContent = content1 + content2;

                Files.write(Paths.get(file3), combinedContent.getBytes(StandardCharsets.UTF_8));

                return "Files successfully combined and written to destination file.";
            } catch (IOException e) {
                return "Error combining files: " + e.getMessage();
            }
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = unionFiles("src/main/resources/file1.txt", "src/main/resources/file2.txt", "src/main/resources/dest.txt");

        result.thenAccept(System.out::println);
        // END
    }
}

