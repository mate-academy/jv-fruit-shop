package core.basesyntax.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FoodStoreDaoImpl implements FoodStoreDao {
    @Override
    public List<String> read(Path fileName) {
        List<String> dailyData;
        try {
            dailyData = Files.readAllLines(fileName);
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file: " + fileName, e);
        }
        dailyData.remove(0);
        return dailyData;
    }
}
