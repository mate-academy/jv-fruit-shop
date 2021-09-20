package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final int HEADER_ID = 0;
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> fileContent;
        File file = new File(filePath);
        try {
            fileContent = Files.readAllLines(file.toPath());
            fileContent.remove(HEADER_ID);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file!", e);
        }
        return fileContent;
    }
}
