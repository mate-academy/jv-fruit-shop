package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {
    private static FruitTransaction fruitTransaction = new FruitTransaction();

    @Override
    public void writeReport(String nameOfFileToReport) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfFileToReport))) {
            writer.write("fruit,quantity" + System.lineSeparator());
            writer.write("banana, " + fruitTransaction.getBanana().getBalance()
                    + System.lineSeparator());
            writer.write("apple, " + fruitTransaction.getApple().getBalance()
                    + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file in direction: " + nameOfFileToReport, e);
        }
    }
}
