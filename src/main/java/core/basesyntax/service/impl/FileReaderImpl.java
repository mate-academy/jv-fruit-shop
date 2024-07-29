package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements Reader {
    @Override
    public List<String> readFromFile(String fromFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFile))) {
            List<String> inputList = new ArrayList<>();
            String value;
            while ((value = reader.readLine()) != null) {
                inputList.add(value);
            }
            return inputList;
        } catch (IOException e) {
            throw new RuntimeException("Error processing file: " + fromFile, e);
        }
    }
}
