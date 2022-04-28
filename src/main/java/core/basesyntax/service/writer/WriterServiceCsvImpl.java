package core.basesyntax.service.writer;

import core.basesyntax.model.FruitTransaction;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterServiceCsvImpl implements WriterService {
    @Override
    public void writeToFile(String outputFile, List<FruitTransaction> fruits) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
            String result = "fruit,quantity" + System.lineSeparator();
            writer.write(result);
            for (FruitTransaction fruit : fruits) {
                result = fruit.getFruit() + "," + fruit.getQuantity() + System.lineSeparator();
                writer.write(result);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write date to file: " + outputFile, e);
        }
    }
}
