package shop.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterServiceImpl implements FileWriterService{
    @Override
    public void write(String fileName, String report) {
        try {
            Files.write(Paths.get(fileName), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fileName, e);
        }
    }
}
