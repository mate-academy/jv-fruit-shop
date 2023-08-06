package core.basesyntax.service.impl;

import core.basesyntax.service.DataReaderService;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvDataReaderServiceImpl implements DataReaderService {

    @Override
    public List<String> readFromFile(String pathToFile) {
        List<String> dataArray = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String data = reader.readLine();
            while (data != null) {
                dataArray.add(data);
                data = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find the file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file", e);
        }
        if (dataArray.isEmpty()) {
            throw new IllegalArgumentException("Data file is empty!");
        }
        return dataArray;
    }
}
