package core.basesyntax.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements core.basesyntax.service.FileWriterService {
    @Override
    public void writeToFile(String report, String pathToFileForWrite) {
        try {
            Files.write(Path.of(pathToFileForWrite), report.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Can't write file:" + report, e);
        }
    }
}
