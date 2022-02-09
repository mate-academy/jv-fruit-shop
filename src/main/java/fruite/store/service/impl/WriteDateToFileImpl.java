package fruite.store.service.impl;

import fruite.store.service.WriteDateService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteDateToFileImpl implements WriteDateService {
    @Override
    public void writeReport(byte[] report, String toFileName) {
        try {
            Files.write(Path.of(toFileName), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write the date to the file: " + toFileName, e);
        }
    }
}
