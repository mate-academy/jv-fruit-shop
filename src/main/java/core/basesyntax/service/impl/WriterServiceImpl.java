package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    private static final String FILE_NAME = "src/main/resources/OutputInfo.csv";

    @Override
    public void writeInfoToFile(String outputInfo) {
        try {
            Files.write(Path.of(FILE_NAME), outputInfo.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + FILE_NAME, e);
        }
    }
}
