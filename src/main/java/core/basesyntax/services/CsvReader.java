package core.basesyntax.services;

import core.basesyntax.serviceinterfaces.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class CsvReader implements FileReader {

    public List<String> read(String source) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(source))) {
            int skippedRow = 1;
            return reader.lines()
                    .skip(skippedRow)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Something wrong with file");
        }
    }
}

