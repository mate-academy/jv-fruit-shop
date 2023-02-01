package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeDataToFile(String report, String filePath) {
        if (report == null || filePath == null) {
            throw new RuntimeException("Please enter valid report and path");
        }
        try {
            Files.writeString(Paths.get(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
