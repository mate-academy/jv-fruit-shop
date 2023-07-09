package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.utility.FruitType;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvWriterService implements DataWriterService {
    private final Map<FruitType, Fruit> fruitMap;
    private final String path;

    public CsvWriterService(Map<FruitType, Fruit> fruitMap, String path) {
        this.fruitMap = fruitMap;
        this.path = path;
    }

    @Override
    public void writeData() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write("fruit,quantity" + System.lineSeparator());
            for (Map.Entry<FruitType, Fruit> fruitEntry : fruitMap.entrySet()) {
                bufferedWriter.write(fruitEntry.getKey().getName() + ","
                        + fruitEntry.getValue().getQuantity() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not write data to report");
        }

    }
}
