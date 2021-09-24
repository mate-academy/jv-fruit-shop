package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import service.inter.ReadService;

public class ReadServiceImpl implements ReadService {
    private static final int FIRST_LINE = 0;

    @Override
    public List<String> readFromFile(String filePath) {
        try {
            List<String> data = Files.readAllLines(new File(filePath).toPath());
            data.remove(FIRST_LINE);
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }

    }
}
