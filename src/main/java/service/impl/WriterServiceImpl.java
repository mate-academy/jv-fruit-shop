package service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String report, String toFileName) {
        File file = new File(toFileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                Files.write(file.toPath(), report.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException("Can't write to file: " + toFileName, e);
            }
        }
    }
}
