package core.basesyntax.service;

import core.basesyntax.model.Fruit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvWriterService implements DataWriterService {
    private final Map<String, Fruit> fruitMap;
    private final String path;

    public CsvWriterService(Map<String, Fruit> fruitMap, String path) {
        this.fruitMap = fruitMap;
        this.path = path;
    }

    @Override
    public void writeData() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write("fruit,quantity" + System.lineSeparator());
            for (Map.Entry<String, Fruit> fruitEntry : fruitMap.entrySet()) {
                bufferedWriter.write(fruitEntry.getKey() + ","
                        + fruitEntry.getValue().getQuantity() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not write data to report");
        }

    }
}
