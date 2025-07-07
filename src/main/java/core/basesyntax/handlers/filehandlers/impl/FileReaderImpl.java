package core.basesyntax.handlers.filehandlers.impl;

import core.basesyntax.handlers.filehandlers.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String name) {
        List<String> dbList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(name))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dbList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Errors reading file: " + name);
        }
        return dbList;
    }
}
