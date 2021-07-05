package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FruitFileReaderImpl implements FruitFileReader {
    @Override
    public List<String> read(String filePath) {
        List<String> result = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            bufferedReader.readLine();
            String currentString;
            while ((currentString = bufferedReader.readLine()) != null) {
                result.add(currentString);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cant found file " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Cant read data from file " + filePath, e);
        }
        return result;
    }
}
