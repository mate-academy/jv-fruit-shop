package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String fileName) {
        if (fileName == null) {
            throw new RuntimeException("Unable to read file: FileName should not be null");
        }
        List<String> linesFromFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                linesFromFile.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file " + fileName, e);
        }
        return linesFromFile;
    }
}
