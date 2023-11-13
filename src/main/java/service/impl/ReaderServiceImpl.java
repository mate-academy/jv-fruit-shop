package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final int HEADER_LINE_INDEX = 0;

    @Override
    public List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("File " + filePath + "not found");
        }
        lines.remove(HEADER_LINE_INDEX);
        return lines;
    }
}
