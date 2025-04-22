package core.basesyntax.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String INPUT_FILE = "fruit_shop_input.csv";

    public List<String> read(String fileName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Path inputPath = Paths.get(Objects.requireNonNull(
                    classLoader.getResource(INPUT_FILE))
                    .toURI()
            );
            return Files.readAllLines(inputPath);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
    }
}
