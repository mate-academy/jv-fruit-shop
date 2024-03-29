package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readData(String path) {
        List<String> dataLines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String data;
            while ((data = reader.readLine()) != null) {
                dataLines.add(data);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + path, e);
        }
        return dataLines;
    }
}
