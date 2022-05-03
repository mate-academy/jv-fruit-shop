package core.basesyntax.service.impl;

import core.basesyntax.service.FileReading;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReadingImpl implements FileReading {
    @Override
    public List<String> readFromFile(String path) {
        List<String> sourceData = new ArrayList<>();
        File file = new File(path);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String readingLine;
            while ((readingLine = bufferedReader.readLine()) != null) {
                sourceData.add(readingLine);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read all line" + path, e);
        }
        return sourceData;
    }
}
