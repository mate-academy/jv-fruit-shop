package core.basesyntax.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader{
    @Override
    public List<String> read(String fileName) {
        try {
            return new ArrayList<>(Files.readAllLines(Path.of(fileName)));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file in FileReaderImpl" + e);
        }
    }
}
