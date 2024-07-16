package core.basesyntax.service.impl;

import core.basesyntax.db.FruitTransaction;
import core.basesyntax.service.WriterService;
import java.io.FileWriter;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToCsv(List<FruitTransaction> list, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for (FruitTransaction fruitTransaction : list) {
                fileWriter.write(fruitTransaction
                        .getFruit()
                        + ","
                        + fruitTransaction.getQuantity() + "\n");
            }
            System.out.println("Successfully written");
            fileWriter.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
