package service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    private static final String SEPARATOR = File.separator;

    @Override
    public void writeToFile(String finalReport, String filePath) {
        String newFilePath = filePath + SEPARATOR + "Balance_Report.csv";
        try {
            Files.writeString(Path.of(newFilePath), finalReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file:" + filePath, e);
        }
    }
}
