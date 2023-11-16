package core.basesyntax.service.impl;

import core.basesyntax.service.ReadDataFromFileService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataFromFileServiceImpl implements ReadDataFromFileService {
    @Override
    public List<String> readFromFile(String path) {
        List<String> listString = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String header = reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                listString.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + path, e);
        }
        return listString;
    }
}
