package core.basesyntax.dao.impl;

import core.basesyntax.dao.FileDao;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileDaoImpl implements FileDao {
    @Override
    public List<String> readFromFile(String fileName) {
        File file = new File(fileName);

        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }
    }

    @Override
    public void writeToFile(String fileName, String reportString) {
        try {
            Files.write(Paths.get(fileName), reportString.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName, e);
        }
    }
}
