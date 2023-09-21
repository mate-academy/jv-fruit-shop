package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements FileReader {
    public static final String INPUT_FILE_NAME = "src/main/resources/fruits.csv";
    private static final String DELIMITER = ",";
    private List<String[]> strings;

    @Override
    public List<String[]> readFile() {

        try {
            strings = Files.readAllLines(Path.of(INPUT_FILE_NAME))
                    .stream()
                    .map(words -> words.split(DELIMITER))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException("Error reading file " + INPUT_FILE_NAME);
        }
        return strings;
    }
}
