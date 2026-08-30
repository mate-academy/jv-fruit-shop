package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String data, String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new RuntimeException("File path is null or empty");
        }
        if (data == null) {
            throw new RuntimeException("Data to write is null");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file by path: " + filePath, e);
        }
    }
}
