package core.basesyntax.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String[]> readFromFile(String pathToFile) {
        List<String[]> dataFromFile = new ArrayList<>();
        try (BufferedReader br = Files
                .newBufferedReader(Path.of(pathToFile), StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                dataFromFile.add(attributes);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file" + pathToFile, e);
        }
        return dataFromFile;
    }
}
