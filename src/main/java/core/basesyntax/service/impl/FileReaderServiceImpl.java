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
        File readFromFile = new File(filePath);
        List<String> dataFromFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(readFromFile))) {
            String dataLine = bufferedReader.readLine();
            while (dataLine != null) {
                dataFromFile.add(dataLine);
                dataLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from " + filePath, e);
        }
        return dataFromFile;
    }
}
