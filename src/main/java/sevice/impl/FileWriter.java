package sevice.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import service.FileWriterService;

public class FileWriter implements FileWriterService {
    private static final int HEADER_INDEX = 0;
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public boolean writeToFile(String filePath, List<String> report) {
        if (report == null) {
            return false;
        }
        report.add(HEADER_INDEX, HEADER);
        Path path = Paths.get(filePath);
        report.forEach(s -> {
            try {
                Files.writeString(path, s, StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException("Can't find such file" + filePath);
            }
        });
        return true;
    }
}
