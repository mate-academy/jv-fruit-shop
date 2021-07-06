package reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFromFile implements Reader<String, Path> {
    @Override
    public List<String> read(Path path) {
        List<String> data;
        try {
            data = Files.readAllLines(path);
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file :(", e);
        }
    }
}
