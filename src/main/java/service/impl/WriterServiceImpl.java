package service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String outputFilePath, List<String> report) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
            report.forEach(writer::println);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file: " + outputFilePath, e);
        }
    }
}


