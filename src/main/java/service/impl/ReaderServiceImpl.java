package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final int TITLE_LINE_INDEX = 0;

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> dailyData;
        try {
            dailyData = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
        dailyData.remove(TITLE_LINE_INDEX);
        return dailyData;
    }
}
