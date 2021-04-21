package core.basesyntax.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Util {
    private static final String FILE_ERROR = "File doesn't exist or can't be found";

    public static List<String> readFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(FILE_ERROR, e);
        }
    }

    public static void writeFile(String fileName, String data) {
        try {
            Files.writeString(Path.of(fileName), data);
        } catch (IOException e) {
            throw new RuntimeException(FILE_ERROR, e);
        }
    }
}
