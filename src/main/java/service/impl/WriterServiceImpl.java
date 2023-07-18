package service.impl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(List<String> report, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (String entry : report) {
                writer.println(entry);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file with such name " + fileName, e);
        }
    }
}
