package mate.academy.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import mate.academy.service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String filePath, String data) {
        File file = new File(filePath);
        try {
            Files.write(file.toPath(), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + filePath, e);
        }
    }
}
