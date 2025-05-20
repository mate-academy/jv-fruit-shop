package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            List<String> dataList = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                dataList.add(line);
            }
            return dataList;

        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + e.getMessage());
        }
    }
}
