package core.basesyntax.service.impl;

import core.basesyntax.dao.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String fileName) {
        if (fileName == null) {
            throw new RuntimeException("File is empty");
        }
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;

        } catch (Exception e) {
            throw new RuntimeException("Unable to read the file: " + e);
        }

    }
}
