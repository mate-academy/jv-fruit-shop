package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriteToFile;

public class WriteToCsvFileImpl implements WriteToFile {
    @Override
    public void writeToCsvFile(String filePath, String reportData) {
        try {
            Files.writeString(Path.of(filePath), reportData);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }
    }
}
