package core.basesyntax.dao;

import core.basesyntax.model.FruitTransactionParser;
import core.basesyntax.model.Storage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {
    private static FruitTransactionParser fruitTransactionParser = new FruitTransactionParser();
    private Storage storage = new Storage();

    @Override
    public String generateReport(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String textInReport = "fruit,quantity\n"
                    + "banana, " + storage.getStorageOfFruits()
                    .get(fruitTransactionParser.getBanana()) + "\n"
                    + "apple, " + storage.getStorageOfFruits()
                    .get(fruitTransactionParser.getApple());
            writer.write(textInReport);
            return textInReport;
        } catch (IOException e) {
            throw new RuntimeException("Can't find file in direction: " + fileName, e);
        }
    }
}
