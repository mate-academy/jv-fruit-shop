package core.basesyntax.service.impl;

import core.basesyntax.service.ReadService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadServiceImpl implements ReadService {

    @Override
    public List<String> readFile(Path path) {
        List<String> fileData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String value = reader.readLine();
            value = reader.readLine();
            while (value != null) {
                fileData.add(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + path.toFile(), e);
        }
        return fileData;
    }
}
