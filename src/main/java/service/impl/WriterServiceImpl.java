package service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String fileName, String report) {
        try (OutputStreamWriter streamWriter =
                     new OutputStreamWriter(new FileOutputStream(fileName))) {
            streamWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write a file " + fileName, e);
        }
    }
}
