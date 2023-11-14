package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("File " + filePath + " not found.");
        }
        lines.remove(0);
        return lines;
    }
}
