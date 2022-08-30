package core.basesyntax.service.servise.impl;

import core.basesyntax.service.servise.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final String HEADER = "type,fruit,quantity";

    @Override
    public List<String> read(String fileName) {
        List<String> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            String line = reader.readLine();

            while (line != null) {
                if (line.equals(HEADER)) {
                    line = reader.readLine();
                }
                records.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName);
        }
        return records;
    }
}
