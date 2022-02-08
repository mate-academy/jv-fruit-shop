package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final int INFO_LINE = 0;
    private static final String MESSAGE = "Can't read data from file: ";

    @Override
    public List<String> readFile(String fileName) {
        List<String> data;
        try {
            data = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(MESSAGE + fileName, e);
        }
        if (data.size() != 0) {
            data.remove(INFO_LINE);
        }
        return data;
    }
}
