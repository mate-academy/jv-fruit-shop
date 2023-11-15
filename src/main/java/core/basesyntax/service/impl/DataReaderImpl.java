package core.basesyntax.service.impl;

import core.basesyntax.service.DataReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReaderImpl implements DataReader<String> {

    @Override
    public List<String> dataFromFile(String fromFile) {
        List<String> lines = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile))) {
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file" + fromFile, e);
        }
        return lines;
    }
}
