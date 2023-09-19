package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import service.FileWriter;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeReportToFile(String filePath, String report) {
        try {
            Files.writeString(Paths.get(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file by path: " + filePath, e);
        }
    }
}
