package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        File processFile = new File(filePath);
        List<String> responseList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(processFile))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                responseList.add(value);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + filePath, e);
        }
        return responseList;
    }
}
