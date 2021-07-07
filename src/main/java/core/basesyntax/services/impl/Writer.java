package core.basesyntax.services.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Writer {
    private  String stockFile;

    public Writer(String stockFile) {
        this.stockFile = stockFile;
    }

    public void doWrite(Storage storage) {
        try (FileWriter writerFile = new FileWriter(stockFile)) {
            Map<String, Integer> map = new HashMap<>();
            storage.getFruits()
                    .stream()
                    .filter(fruit -> fruit.getStockBalance() > 0)
                    .forEach(fruit -> {
                        sum(map, fruit);
                    });

            writerFile.write("fruit,quantity\n");
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                writerFile.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("No write access to file");
        }
    }

    private void sum(Map<String, Integer> map, Fruit fruit) {
        if (map.containsKey(fruit.getType())) {
            map.put(fruit.getType(), fruit.getStockBalance()
                    + map.get(fruit.getType()));
        } else {
            map.put(fruit.getType(), fruit.getStockBalance());
        }
    }
}
