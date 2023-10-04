package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readFromFile(String path) {
        File file = new File(path);
        List<String> listLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listLines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + file, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + e);
        }
        return listLines;
    }
}
