package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromCsvFileImpl implements FileReader {

    @Override
    public List<String> read(String path) {
        List<String> list = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("File was not found");
        }
        return list;
    }
}
