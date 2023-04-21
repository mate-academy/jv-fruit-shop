package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderFromFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFromFileImpl implements ReaderFromFile {
    @Override
    public List<String> readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                lines.add(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fileName, e);
        }
        return lines;
    }
}
