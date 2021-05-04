package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadServiceFromCsvImpl implements ReadService {

    @Override
    public List<String> readFile(String filePath) {
        List<String> dataFromFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
          String text = "";
          while ((text = bufferedReader.readLine()) != null) {
                dataFromFile.add(text);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read file" + filePath);
        }
        return dataFromFile;
    }
}
