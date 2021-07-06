package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        List<String> result = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filePath));
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
