package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.interfaces.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void fileWriteTo(String report, String destination) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destination))) {
            bufferedWriter.write(report);
        } catch (IOException exception) {
            throw new RuntimeException("Cant write Report to File", exception);
        }
    }
}
