package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterServiceImpl implements WriterService {
    private static final String FILE_WRITE_EXCEPTION_MESSAGE = "Can't write to file: ";

    @Override
    public void writeToFile(String fileName, String report) {
        Path path = Paths.get(fileName);
        try {
            Files.writeString(path, report);
        } catch (IOException e) {
            throw new RuntimeException(FILE_WRITE_EXCEPTION_MESSAGE + fileName, e);
        }
    }
}
