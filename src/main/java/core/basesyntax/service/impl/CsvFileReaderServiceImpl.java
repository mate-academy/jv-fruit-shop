package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readLineFromFile(String filePath) {
        List<String> listData = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                listData.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error... file not found " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error... can't read file " + filePath);
        }
        return listData;
    }
}
