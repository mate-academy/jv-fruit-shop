package core.basesyntax.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> read(String fileName) {
        List<String> dailyData;
        try {
            dailyData = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file: " + fileName, e);
        }
        return dailyData;
    }

    @Override
    public void write(String content, String fileName) {
        try {
            Files.writeString(Path.of(fileName), content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + fileName, e);
        }
    }
}

