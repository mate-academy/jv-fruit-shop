package core.basesyntax.services.fileprocessing.impl;

import core.basesyntax.services.fileprocessing.FileDataReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReaderCsvImpl implements FileDataReader {
    @Override
    public List<String> readFromFileAndHoldData(String fromFileName) {
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
