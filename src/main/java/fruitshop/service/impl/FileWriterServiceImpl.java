package fruitshop.service.impl;

import fruitshop.service.FileWriterService;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String data, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file: " + filePath, e);
        }
    }
}
