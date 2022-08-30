package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String row = bufferedReader.readLine();
            while (row != null) {
                lines.add(row);
                row = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file " + fileName, e);
        }
        return lines;
    }
}
