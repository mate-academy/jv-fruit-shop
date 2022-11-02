package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    private final Path filePath;

    public FileWriterServiceImpl(Path destFile) {
        this.filePath = destFile;
    }

    @Override
    public void writeToFile(String data) {
        try {
            Files.write(filePath, data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("Unable to write file \"%s\" ", filePath), e);
        }
    }
}
