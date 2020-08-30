package core.basesyntax.services.impl;

import core.basesyntax.Storage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Writer {
    private static final String STOCK_FILE = "src/main/resources/stock.csv";

    public void doWrite(Storage storage) {
        try (FileWriter writerFile = new FileWriter(STOCK_FILE)) {
            Map<String, Integer> map = new HashMap<>();
            storage.getFruits()
                    .stream()
                    .filter(fruit -> fruit.getStock_balance() > 0)
                    .forEach(fruit -> {
                        if (map.containsKey(fruit.getType())) {
                            map.put(fruit.getType(), fruit.getStock_balance()
                                    + map.get(fruit.getType()));
                        } else {
                            map.put(fruit.getType(), fruit.getStock_balance());
                        }
                    });

            writerFile.write("fruit,quantity\n");
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                writerFile.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("No write access to file");
        }
    }
}
