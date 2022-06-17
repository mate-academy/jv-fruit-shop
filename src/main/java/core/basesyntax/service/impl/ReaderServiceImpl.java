package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> linesFile = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            reader.readLine();
            String line = reader.readLine();
            while (line != null) {
                linesFile.add(line);
                line = reader.readLine();
            }
            return linesFile;
        } catch (IOException e) {
            throw new RuntimeException("Cant find file", e);
        }
    }
}
