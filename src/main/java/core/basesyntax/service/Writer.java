package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Writer {
    public void write(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("fruit, quantity" + "\n");
            for (Map.Entry<String, Fruit> item : Fruit.getFruitStorage().entrySet()) {
                writer.append(item.getKey()).append(", ").append("" + item.getValue().getAmount());
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with file!");
        }
    }
}
