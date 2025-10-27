package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String filePath) {
        List<String> result = List.of();
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            result = lines.skip(1).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("failed to read file: " + filePath
                    + " on path: " + filePath, e);
        }
        return result;
    }
}
