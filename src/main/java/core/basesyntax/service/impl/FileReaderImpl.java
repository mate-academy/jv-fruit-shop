package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements Reader {
    @Override
    public List<String> readFromFile(String fileName) {
        File fruitStatistics = new File(fileName);
        List<String> lines = new ArrayList<>();
        try (BufferedReader fruitReader = new BufferedReader(new FileReader(fruitStatistics))) {
            String line = fruitReader.readLine();
            while (line != null) {
                lines.add(line);
                line = fruitReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read from file! Filename - " + fileName
                    + ", exception - ", e);
        }
        return lines;
    }
}
