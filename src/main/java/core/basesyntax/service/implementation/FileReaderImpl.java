package core.basesyntax.service.implementation;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            return Files.lines(path)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file" + filePath, e);
        }
    }
}
