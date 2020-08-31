package core.basesyntax.service.iooperations;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitStorage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class Writer {

    public void write(String fileName) {
        CSVFormat format = CSVFormat.DEFAULT.withHeader("fruit", "quantity");
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(fileName), format)) {
            for (Map.Entry<String, Fruit> item : FruitStorage.getFruitStorage().entrySet()) {
                printer.printRecord(item.getKey(), item.getValue().getAmount());
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with writing to file", e);
        }
    }
}
