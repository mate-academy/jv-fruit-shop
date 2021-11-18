package core.basesyntax.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputData {
    private final String fileName;
    private List<String> parsedFile;

    public InputData(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public List<String> getParsedFile() {
        return parsedFile;
    }

    public void parseFile() {
        Stream<String> streamFromFile;
        try {
            streamFromFile = Files.lines(Path.of("src", "main", "resources", fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file: " + fileName);
        }
        parsedFile = streamFromFile
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
