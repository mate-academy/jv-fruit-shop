package service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import service.WriterService;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeInFile(String fileName, String data) {
        File file = new File(fileName);
        if (file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(data);
            } catch (IOException e) {
                throw new RuntimeException("Can't find the file");
            }
        }
    }
}

