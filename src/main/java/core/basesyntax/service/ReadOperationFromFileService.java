package core.basesyntax.service;

import core.basesyntax.impl.Consumer;
import core.basesyntax.impl.Returner;
import core.basesyntax.impl.Supplier;
import core.basesyntax.model.FruitBox;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class ReadOperationFromFileService {
    private static final String SPLITTER = ",";
    private static final String SUPPLIER = "s";
    private static final String CONSUMER = "b";
    private static final String RETURNER = "r";

    public void read(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(SPLITTER);
                FruitBox fruit
                        = new FruitBox(
                        data[1], Integer.parseInt(data[2]), LocalDate.parse(data[3]));
                switch (data[0]) {
                    case SUPPLIER:
                        Operator<FruitBox> supplier = new Supplier();
                        supplier.execute(fruit);
                        break;
                    case CONSUMER:
                        Operator<FruitBox> consumer = new Consumer();
                        consumer.execute(fruit);
                        break;
                    case RETURNER:
                        Operator<FruitBox> returner = new Returner();
                        returner.execute(fruit);
                        break;
                    default:
                        throw new IllegalArgumentException("Wrong operation");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Wrong path");
        }
    }
}
