package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteScvServiceIml implements WriteScvService {
    @Override
    public void writeDataScvFile(List<FruitTransaction> fruitTransactionList, String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("fruit,quantity\n");
            for (FruitTransaction fruit : fruitTransactionList) {
                fileWriter.write(fruit.getFruit() + "," + fruit.getQuantity() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
