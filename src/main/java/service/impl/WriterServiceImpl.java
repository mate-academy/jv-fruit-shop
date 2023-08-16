package service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String fileName, List<String> data) {
        File file = new File(fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(String.join(System.lineSeparator(), data));
        } catch (IOException e) {
            throw new RuntimeException("Can't find the file by path " + fileName, e);
        }
    }
}
