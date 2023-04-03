package core.basesyntax.service.fileservice;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeDataToFile(String data, String path) {
        try {
            Files.writeString(Path.of(data), path);
        } catch (Exception e) {
            throw new RuntimeException("Can't write data to this file!");
        }
    }
}
