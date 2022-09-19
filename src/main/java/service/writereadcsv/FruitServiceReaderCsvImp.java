package service.writereadcsv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitServiceReaderCsvImp implements FruitServiceReaderCsv {

    @Override
    public List<String> readFromFileCsv(String filePath) {
        List<String> fruitsList;
        try {
            fruitsList = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + filePath, e);
        }
        return fruitsList;
    }
}
