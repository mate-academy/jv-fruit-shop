package core.basesyntax.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements core.basesyntax.service.FileReader {
    @Override
    public List<String> readFromFile(String fromFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFile))) {
            List<String> inputList = new ArrayList<>();
            String value;
            while ((value = reader.readLine()) != null) {
                inputList.add(value);
            }
            return inputList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + fromFile, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file: " + fromFile, e);
        }
    }
}
