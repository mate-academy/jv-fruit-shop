package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {
    @Override
    public List<String> read(String fileName) {
        List<String> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();

            while (line != null) {
                records.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName);
        }
        return records;
    }
}
