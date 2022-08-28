package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterService implements Writer {
    private static final String DIVIDER = ",";
    private static final String HEADER = "fruit,quantity";
    private final String outputFIle;
    private final List<Fruit> fruitData;

    public WriterService(String outputFIle, List<Fruit> fruitData) {
        this.outputFIle = outputFIle;
        this.fruitData = fruitData;
    }

    @Override
    public void writeToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFIle))) {
            bufferedWriter.write(HEADER + System.lineSeparator());
            for (Fruit fruit : fruitData) {
                bufferedWriter.write(fruit.getFruitName() + DIVIDER
                        + fruit.getAmount() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find output file: " + outputFIle, e);
        }
    }
}
