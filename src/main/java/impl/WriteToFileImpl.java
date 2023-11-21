package impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriteToFileService;

public class WriteToFileImpl implements WriteToFileService {
    @Override
    public void writeToFile(String filePath, String report) {
        try {
            Files.writeString(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the " + filePath, e);
        }
    }
}
