package core.basesyntax.dao;

import static core.basesyntax.model.Storage.storageOfFruits;

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
            StringBuilder builder = new StringBuilder();
            builder.append("fruit,quantity" + System.lineSeparator())
                    .append("banana, " + storageOfFruits.get(fruitTransactionParser.getBanana())
                            + System.lineSeparator())
                    .append("apple, " + storageOfFruits.get(fruitTransactionParser.getApple()));
            String textInReport = builder.toString();
            writer.write(textInReport);
            return textInReport;
        } catch (IOException e) {
            throw new RuntimeException("Can't find file in direction: " + fileName, e);
        }
    }
}
