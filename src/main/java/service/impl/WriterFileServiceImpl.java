package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import service.WriterFileService;

public class WriterFileServiceImpl implements WriterFileService {

    @Override
    public void writeToFile(List<String> lines, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Can`t write to file" + fileName, e);
        }
    }
}
