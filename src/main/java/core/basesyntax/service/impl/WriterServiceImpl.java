package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {

    private static final String OUTPUT_FILE = "src/main/resources/outputData.csv";

    @Override
    public void write(String report) {
        Path path = Path.of(OUTPUT_FILE);
        try {
            Files.writeString(path, report);
        } catch (IOException e) {
            throw new RuntimeException("Can not write the file",e);
        }
    }
}
