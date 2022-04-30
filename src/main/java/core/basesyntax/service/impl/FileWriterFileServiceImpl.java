package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterFileServiceImpl implements FileWriterService {
    @Override
    public void write(String filePath, String report) {
        try {
            Files.write(Paths.get(filePath), report.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Cant create file" + e);
        }
    }
}
