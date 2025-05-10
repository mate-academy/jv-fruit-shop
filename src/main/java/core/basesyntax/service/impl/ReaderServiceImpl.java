package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> allLines = new ArrayList<>();
        File inputFile = new File(filePath);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                allLines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file", e);
        }
        return allLines;
    }
}
