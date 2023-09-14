package mate.academy.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mate.academy.service.Reader;

public class ReaderImpl implements Reader {
    public List<String> readFromFile(String filePath) {
        List<String> inputData;
        try (Stream<String> lines = Files.lines(Path.of(filePath))) {
            inputData = lines.filter(line -> !line.isEmpty())
                    .map(String::trim)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + filePath, e);
        }
        return inputData;
    }
}
