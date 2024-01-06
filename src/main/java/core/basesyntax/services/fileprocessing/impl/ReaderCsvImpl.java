package core.basesyntax.services.fileprocessing.impl;

import core.basesyntax.services.fileprocessing.Reader;//If I apply your naming, there is a conflict in imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderCsvImpl implements Reader {
    @Override
    public List<String> readFile(String fromFileName) {
        List<String> rawData = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                rawData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        return rawData;
    }
}
