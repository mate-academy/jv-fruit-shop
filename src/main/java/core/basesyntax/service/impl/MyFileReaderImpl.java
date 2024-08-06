package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MyFileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
        return lines;
    }
}
