package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private static final int FIRST_LINE_INDEX = 0;

    @Override
    public List<String> readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName);
        }
        removeFirstLine(result);
        return result;
    }

    private void removeFirstLine(List<String> list) {
        if (!list.get(FIRST_LINE_INDEX).startsWith("[brsp],")) {
            list.remove(FIRST_LINE_INDEX);
        }
    }
}
