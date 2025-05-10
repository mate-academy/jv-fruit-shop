package core.basesyntax.services.fileprocessing.impl;

import core.basesyntax.services.fileprocessing.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderCsvImpl implements Reader {
    @Override
    public List<String> readFile(String filename) {
        List<String> rawData = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                rawData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filename, e);
        }
        return rawData;
    }
}
