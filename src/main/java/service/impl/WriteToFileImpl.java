package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import service.WriteToFile;

public class WriteToFileImpl implements WriteToFile {

    @Override
    public boolean writeToFile(String filePath, List<String> report) {
        if (report == null) {
            return false;
        }
        Path path = Paths.get(filePath);
        try {
            Files.writeString(path,"fruit,quantity" + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Can't find such file" + filePath);
        }
        report.stream()
                .forEach(s -> {
                    try {
                        Files.writeString(path, s, StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        throw new RuntimeException("Can't find such file" + filePath);
                    }
                });
        return true;
    }
}
