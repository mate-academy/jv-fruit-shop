package core.basesyntax.service;

import core.basesyntax.model.FruitType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterImpl implements Writer{
    @Override
    public void writeRepo (Map<FruitType, Integer> fruitServiceMap) {
        String fileName = "src/main/java/Result.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("fruit,quantity");
            writer.newLine();
            fruitServiceMap.forEach((fruitType, value) -> {
                int quantity = value;
                if (quantity < 0) {
                    throw new RuntimeException("Balance is negative");
                }
                try {
                    writer.write(String.valueOf(fruitType).toLowerCase());
                    writer.write("," + quantity);
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
