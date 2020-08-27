package core.basesyntax.read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile implements FileReader {
    @Override
    public List<String> readFile(String filePath) {
        Path path = Paths.get(filePath);
        List<String> strings = null;
        try {
            strings = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (strings != null && strings.size() != 0) {
            strings.remove(0);
        }
        return strings;
    }
}
