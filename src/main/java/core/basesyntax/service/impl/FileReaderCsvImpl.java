package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderCsvImpl implements FileReader {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                lines.add(value);
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Data couldn't read from file " + fileName, e);
        }
        if (lines.size() > 0) {
            lines.remove(0);
        }
        return lines;
    }
}
