package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderServiceCsvImpl implements ReaderService {
    @Override
    public String readData(String filePath) {
        StringBuilder csvData = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                csvData.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t find file " + filePath, e);
        }
        return csvData.toString();
    }
}
