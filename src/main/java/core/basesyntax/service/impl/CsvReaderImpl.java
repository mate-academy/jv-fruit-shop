package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CsvReaderImpl implements FileReader {
    private static final String COMMA_DELIMITER = ",";
    private static final String FILE_PATH = "src/main/resources/";

    @Override
    public List<String> readFile(String fileName) {

        if (fileName == null) {
            throw new RuntimeException("Provided file name is null");
        }

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br =
                     new BufferedReader(new java.io.FileReader(FILE_PATH + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException("File was not found: " + fileName, e);
        }
        return records
                .stream()
                .flatMap(Collection::stream)
                .toList();
    }
}
