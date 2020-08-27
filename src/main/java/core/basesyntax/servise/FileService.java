package core.basesyntax.servise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.NoSuchElementException;

public class FileService {
    private static final String HEAD = "\"type\",\"fruit\",\"quantity\",\"date\"";

    public List<String> getListFromInputFile(String filePath) {
        if (!filePath.endsWith(".csv")) {
            throw new IllegalArgumentException("Incorrect file type!!!");
        }
        List<String> strings;
        try {
            strings = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new NoSuchElementException("The file with path " + filePath
                    + " cannot be read");
        }
        if (strings.indexOf(HEAD) >= 0) {
            strings.remove(0);
            return strings;
        }
        throw new IllegalArgumentException("Incorrect file text!");
    }

    public void writeOutputFile(List<String> strings, String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
            for (String row : strings) {
                Files.writeString(path, row + "\n", StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("The file can't be written!!!");
        }
    }
}
