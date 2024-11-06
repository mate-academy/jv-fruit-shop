package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements Reader {
    @Override
    public List<String> readFile(String path) {
        List<String> rows = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    rows.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("The file by path " + path
                    + " cannot be read or does not exist.", e);
        }
        return rows;
    }
}
