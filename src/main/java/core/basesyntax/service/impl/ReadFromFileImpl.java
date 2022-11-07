package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFromFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {
    @Override
    public List<String> readFile(String filePath) {
        File file = new File(filePath);
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file " + file, e);
        }
        return dataFromFile;
    }
}
