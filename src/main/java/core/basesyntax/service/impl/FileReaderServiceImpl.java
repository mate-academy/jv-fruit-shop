package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String path) {
        List<String> fileContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while (((line = reader.readLine()) != null)) {
                fileContent.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file " + path, e);
        }
        return fileContent;
    }
}
