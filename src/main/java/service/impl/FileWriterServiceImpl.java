package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import service.WritingIntoCsvFileService;

public class FileWriterServiceImpl implements WritingIntoCsvFileService {
    @Override
    public void writeIntoFile(List<String> report, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : report) {
                bw.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write into the file " + fileName);
        }

    }
}
