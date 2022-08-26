package services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import services.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> getFruitData(String filePath) {
        List<String> transactions = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                transactions.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + filePath, e);
        }
        return transactions;
    }
}
