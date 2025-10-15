package core.basesyntax.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String source) {
        try {
            return Files.readAllLines(Paths.get(source))
                    .stream()
                    .filter(line -> !line.equals("type,fruit,quantity"))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Error reading file " + source, e);
        }
    }
}
