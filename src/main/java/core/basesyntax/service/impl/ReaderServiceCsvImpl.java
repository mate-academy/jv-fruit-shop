package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ReaderServiceCsvImpl implements ReaderService {
    private static final int HEADER_ROW_INDEX = 1;

    @Override
    public List<String> readFromFile(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines
                    .skip(HEADER_ROW_INDEX)
                    .toList();
        } catch (IOException ex) {
            throw new RuntimeException("Can't find file by path: " + filePath, ex);
        }
    }
}
