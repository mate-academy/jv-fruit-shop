package core.basesyntax.service.implementations;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void writeToFile(String filePath, String report) {
        try {
            Files.writeString(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write Report to the File " + filePath, e);
        }
    }
}
