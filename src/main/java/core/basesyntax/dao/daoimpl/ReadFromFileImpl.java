package core.basesyntax.dao.daoimpl;

import core.basesyntax.dao.ReadFromFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {
    @Override
    public List<String> readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file: " + fileName, e);
        }
    }
}
