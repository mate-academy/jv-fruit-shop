package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> read(String filePath) {
        List<String> records = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                records.add(line.trim());
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading file at path :" + filePath);
        }
        return records;
    }
}
