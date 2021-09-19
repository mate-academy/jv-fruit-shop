package core.basesyntax.fileReader;

//
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile{
    @Override
    public List<String> read(String file) {
        try {
            return Files.readAllLines(Path.of(file));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
