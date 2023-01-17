package core.basesyntax.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> readFromFile(String filePath) {
        File file = new File(filePath);
        List<String> lines = new ArrayList<>();
        String line;
        try (BufferedReader br =
                     new BufferedReader(new FileReader(file))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + file.getPath(), e);
        }
        return lines;
    }
}
