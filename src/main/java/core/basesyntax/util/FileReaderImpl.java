package core.basesyntax.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String filePath) {
        try {
            return Files.lines(Path.of(filePath))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file by path " + filePath);
        }
    }
}
