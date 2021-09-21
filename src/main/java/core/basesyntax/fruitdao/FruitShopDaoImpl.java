package core.basesyntax.fruitdao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitShopDaoImpl implements FruitShopDaoCsv {
    @Override
    public List<String> readFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + fileName, e);
        }
    }

    @Override
    public void writeToFile(String fileName, String report) {
        try {
            Files.write(new File(fileName).toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + fileName);
        }
    }
}
