package core.basesyntax.service.impl;

import core.basesyntax.service.ReadCsvFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReadCsvFileServiceImpl implements ReadCsvFileService {
    private static final int FILE_HEADER_LINE = 1;

    @Override
    public List<String> readFromFile(String path) {
        try {
            return Files.readAllLines(Path.of(path)).stream()
                    .skip(FILE_HEADER_LINE).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("Can`t get data from file %s", path));
        }
    }
}
