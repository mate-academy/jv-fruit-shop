package core.basesyntax.service.impl;

import core.basesyntax.service.DataReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReaderImpl implements DataReader<String> {

    private static final String FILE_PART = "src/main/resources/inputData.csv";

    @Override
    public List<String> dataFromFile() {
        List<String> lines = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PART))) {
            boolean firstLine = true;
            while ((line = bufferedReader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file");
        }
        return lines;
    }
}
