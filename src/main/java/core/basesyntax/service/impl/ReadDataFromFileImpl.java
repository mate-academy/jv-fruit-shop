package core.basesyntax.service.impl;

import core.basesyntax.service.ReadDataFromFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataFromFileImpl implements ReadDataFromFile {
    private static final int HEADER_INDEX = 0;
    private static List<String> STRING_LIST_DATA = new ArrayList<>();

    @Override
    public List<String> readStatisticFromFile(String fromFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                STRING_LIST_DATA.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't not read file:" + fromFileName, e);
        }
        if (STRING_LIST_DATA.isEmpty()) {
            throw new RuntimeException("Data from input file empty");
        }
        STRING_LIST_DATA.remove(HEADER_INDEX);
        return STRING_LIST_DATA;
    }
}
