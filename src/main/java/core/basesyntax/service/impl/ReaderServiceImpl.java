package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final int INDEX_OF_DESCRIPTION_LINE = 0;

    @Override
    public List<String> readFromFile(String pathToFile) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("You can`t read data from file " + pathToFile, e);
        }
        lines.remove(INDEX_OF_DESCRIPTION_LINE);
        return lines;
    }
}
