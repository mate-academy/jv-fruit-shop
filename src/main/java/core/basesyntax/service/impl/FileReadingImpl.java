package core.basesyntax.service.impl;

import core.basesyntax.service.FileReading;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReadingImpl implements FileReading {

    @Override
    public List<String> readFromFile(Path path) {
        List<String> listFromFile = new ArrayList<>();
        File file = new File(String.valueOf(path));

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String lineFromFile;
            while ((lineFromFile = bufferedReader.readLine()) != null) {
                listFromFile.add(lineFromFile);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read all line" + path, e);
        }
        return listFromFile;
    }
}
