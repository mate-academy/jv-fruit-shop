package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;

import java.io.*;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private List<String> listLines;

    @Override
    public List<String> readFromFile(File path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listLines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + path, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + e);
        }
        return listLines;
    }
}
