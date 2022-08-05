package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    private static final String FILE_HEADING = "fruit,quantity";

    @Override
    public void writeToFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(FILE_HEADING);
            for (Map.Entry<Fruit, Integer> fruitData : FruitStorage.fruitNumbersMap.entrySet()) {
                writer.newLine();
                writer.write(fruitData.getKey().getFruitName() + ","
                        + fruitData.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + path, e);
        }
    }
}
