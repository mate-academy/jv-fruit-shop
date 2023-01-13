package solid.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import solid.service.WriteFileService;

public class WriteFileServiceImpl implements WriteFileService {
    @Override
    public void writeToFile(Path path, String data) {
        try {
            Files.writeString(path, data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file " + path.getFileName() + e);
        }
    }
}
