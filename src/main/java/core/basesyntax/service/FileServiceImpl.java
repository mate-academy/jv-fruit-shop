package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {
    private static final int FIRST_ELEMENT_INDEX = 0;

    @Override
    public List<String> read(String fileName) {
        List<String> dailyData;
        try {
            dailyData = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file: " + fileName, e);
        }
        dailyData.remove(FIRST_ELEMENT_INDEX);
        return dailyData;
    }

    @Override
    public void write(List<String> content, String fileName) {
        try {
            Files.write(Path.of(fileName), content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + fileName, e);
        }
    }
}

