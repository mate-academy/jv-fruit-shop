package core.basesyntax.service;

import core.basesyntax.impl.Returner;
import core.basesyntax.impl.Seller;
import core.basesyntax.impl.Supplier;
import core.basesyntax.model.FruitBox;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ReadOperationFromFileService {
    private static final String SPLITTER = ",";
    private static final String SUPPLIER = "s";
    private static final String CONSUMER = "b";
    private static final String RETURNER = "r";

    public void read(String filePath) {
        Map<String, Operator<FruitBox>> operations = new HashMap<>();
        operations.put(SUPPLIER, new Supplier());
        operations.put(CONSUMER, new Seller());
        operations.put(RETURNER, new Returner());

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(SPLITTER);
                FruitBox fruit
                        = new FruitBox(
                        data[1], Integer.parseInt(data[2]), LocalDate.parse(data[3]));
                if (operations.containsKey(data[0])) {
                    operations.get(data[0]).execute(fruit);
                } else {
                    throw new IllegalArgumentException("Wrong operation");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Wrong path");
        }
    }
}
