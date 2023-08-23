package core.basesyntax.service.impl;

import core.basesyntax.service.impl.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final String EXCEPTION_INFO
            = "Cannot read file! Check if file has correct path and name";
    private static final String INVALID_INPUT_PARAMETER
            = "Invalid input parameter in readData()";

    @Override
    public List<String> readData(String fromFile) {
        if (fromFile == null) {
            throw new RuntimeException(INVALID_INPUT_PARAMETER);
        }
        try {
            return Files.readAllLines(Path.of(fromFile));
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_INFO, e);
        }
    }
}
