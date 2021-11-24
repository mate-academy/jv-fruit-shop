package core.basesyntax.service.impl;

import core.basesyntax.service.MyReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyCsvReaderImpl implements MyReader {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> lines = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                lines.add(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        boolean remove = lines.remove(lines.get(0));
        return lines;
    }
}
