package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.WriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class WriterServiceImpl implements WriterService {
    private static final String SEPARATOR = System.getProperty("line.separator");

    @Override
    public void writeBalanceOfFruitToFile(Map<Fruit, Integer> balance) {
        try (Writer writer = new FileWriter("src/main/resources/fileBalance.csv")) {
            writer.append("fruit").append(',').append("quantity").append(SEPARATOR);
            for (Map.Entry<Fruit, Integer> entry :balance.entrySet()) {
                writer.append(entry.getKey().getName())
                        .append(',')
                        .append(entry.getValue().toString())
                        .append(SEPARATOR);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write balance to file ", e);
        }
    }
}
