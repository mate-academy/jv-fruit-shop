package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    private static final String HEADER_FRUIT = "fruit";
    private static final String HEADER_QUANTITY = "quantity";

    @Override
    public void writeToFile(String pathToFile, List<Fruit> fruits) {
        StringBuilder builder = new StringBuilder();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile))) {
            builder.append(HEADER_FRUIT)
                    .append(",")
                    .append(HEADER_QUANTITY)
                    .append(System.lineSeparator());
            for (Fruit fruit : fruits) {
                builder.append(fruit.getFruitName())
                        .append(",")
                        .append(fruit.getQuantity())
                        .append(System.lineSeparator());
            }
            writer.write(builder.toString().trim());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + pathToFile, e);
        }
    }
}
