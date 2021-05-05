package core.basesyntax.service.implementations;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String ERROR_MESSAGE = "Can't write Report to the File";

    @Override
    public void writeToFile(String filePath, String report) {
        try {
            Files.writeString(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE + " " + filePath, e);
        }
    }
}
