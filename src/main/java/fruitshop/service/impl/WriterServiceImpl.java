package fruitshop.service.impl;

import fruitshop.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(byte[] data, String fileName) {
        try {
            Files.write(Path.of(fileName), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file");
        }
    }
}
