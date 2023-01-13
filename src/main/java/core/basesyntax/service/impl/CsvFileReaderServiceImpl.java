package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public String readFromFile(String filePath) {
        String dataFromFile = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                dataFromFile += line + "\n";
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
        return dataFromFile;
    }
}
