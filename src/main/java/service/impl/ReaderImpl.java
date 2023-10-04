package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import service.Reader;

public class ReaderImpl implements Reader {
    private static final int OLD_HEADER_INDEX = 1;

    @Override
    public List<String> read(String fromFileName) {
        try {
            return Files.readAllLines(Path.of(fromFileName))
                .stream()
                .skip(OLD_HEADER_INDEX)
                .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Cant read data from file ");
        }
    }
}
