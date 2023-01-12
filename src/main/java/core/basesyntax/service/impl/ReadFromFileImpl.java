package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFromFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {
    private static final String DELIMITER = ",";

    @Override
    public List<String[]> getListFromFile(String fromFileName) {
        String line;
        List<String[]> lines = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFileName));
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line.split(DELIMITER));
            }
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Can`t find this file " + fromFileName, e);
        }
    }
}
