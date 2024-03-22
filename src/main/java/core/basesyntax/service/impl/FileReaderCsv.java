package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderCsv implements FileReader {
    @Override
    public List<String> read(String filePath) {
        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filePath))) {
            bufferedReader.readLine();
            String value = bufferedReader.readLine();
            while (value != null) {
                result.add(value);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath, e);
        }
        return result;
    }
}
