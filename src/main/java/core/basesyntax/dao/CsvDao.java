package core.basesyntax.dao;

import core.basesyntax.exception.CsvFileException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvDao implements FruitShopDao {

    @Override
    public List<String> loadDataFromFile(Path readPath) {
        try {
            List<String> lines = Files.readAllLines(readPath);
            lines.remove(0);
            return lines;
        } catch (IOException e) {
            throw new CsvFileException("Cant read from cvs file " + readPath, e);
        }
    }

    @Override
    public void saveDataToFile(Path writePath, List<String> data) {
        try {
            Files.write(writePath, data);
        } catch (IOException e) {
            throw new CsvFileException("Cant write to cvs file " + writePath, e);
        }
    }
}
