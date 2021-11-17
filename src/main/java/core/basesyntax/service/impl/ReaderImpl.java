package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> dataFromFile = new ArrayList<>();
        String line;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            line = fileReader.readLine();
            while (line != null) {
                dataFromFile.add(line);
                line = fileReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + fileName, e);
        }
        return dataFromFile;
    }
}
