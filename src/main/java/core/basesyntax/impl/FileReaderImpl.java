package core.basesyntax.impl;

import core.basesyntax.service.MyFileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements MyFileReader {
    static final char SEPARATOR = ',';
    static final int SEPARATOR_INDEX = 1;

    public List<String> read(String fileName) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String str;
            while ((str = br.readLine()) != null) {
                if (str.charAt(SEPARATOR_INDEX) == SEPARATOR) {
                    list.add(str);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName);
        }
        return list;
    }
}
