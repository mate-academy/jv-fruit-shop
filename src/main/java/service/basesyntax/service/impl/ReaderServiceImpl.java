package service.basesyntax.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.basesyntax.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readLines(String path) {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("path is null or empty");
        }
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file " + path, e);
        }
        return lines;
    }
}
