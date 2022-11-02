package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import service.WriteToFile;

public class WriteToFileImpl implements WriteToFile {
    private static final int INDEX_OF_HEAD = 0;
    private static final String HEAD = "fruit,quantity" + System.lineSeparator();

    @Override
    public boolean writeToFile(String filePath, List<String> report) {
        if (report == null) {
            return false;
        }
        report.add(INDEX_OF_HEAD, HEAD);
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
