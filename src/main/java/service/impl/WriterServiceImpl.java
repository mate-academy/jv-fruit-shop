package service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String file, String report) {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file))) {
            osw.write(report);
            System.out.println("Store report is saved!");
        } catch (IOException e) {
            throw new RuntimeException("Can't write a file");
        }
    }
}
