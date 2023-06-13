package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> readFromFile(String path) {
        List<String> records = new ArrayList<>();
        try {
            records = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + path);
        }
        return records;
    }

    @Override
    public void writeToFile(String path, String reportString) {
        try (Writer writer = new FileWriter(path)) {
            writer.append(reportString);
        } catch (IOException ex) {
            throw new RuntimeException("Can't write data to file " + path);
        }
    }
}
