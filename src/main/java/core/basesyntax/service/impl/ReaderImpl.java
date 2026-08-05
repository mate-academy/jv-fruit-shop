package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderImpl implements Reader {
    public ArrayList<String> readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            ArrayList<String> lines = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
    }
}
