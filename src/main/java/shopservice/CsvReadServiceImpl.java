package shopservice;

import datavalidation.DataValidatorImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReadServiceImpl implements ReadService {

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> dataFromFile = new ArrayList<>();
        try (BufferedReader readFile = new BufferedReader(new FileReader(filePath))) {
            String data = readFile.readLine();
            while ((data != null)) {
                new DataValidatorImpl().validateData(data);
                dataFromFile.add(data);
                data = readFile.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath);
        }
        return dataFromFile;
    }
}
