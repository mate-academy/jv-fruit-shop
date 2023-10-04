package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private List<String> parsedData = new ArrayList<>();

    @Override
    public List<String> read(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parsedData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Something is wrong with file " + filePath, e);
        }

        return parsedData;
    }
}
