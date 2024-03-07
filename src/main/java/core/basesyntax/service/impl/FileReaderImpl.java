package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String pathToFile) {
        File file = new File(pathToFile);
        List<String> fileContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                fileContent.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + pathToFile, e);
        }
        return fileContent;
    }
}
