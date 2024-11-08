package core.basesyntax.dao;

import core.basesyntax.model.Account;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReportImpl implements WriteReport {
    private Account account = new Account();

    @Override
    public void writeReport(String nameOfFileToReport) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfFileToReport))) {
            writer.write("fruit,quantity\n");
            writer.write("banana, " + account.getBananaBalance() + "\n");
            writer.write("apple, " + account.getAppleBalance() + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Can't find file in direction: " + nameOfFileToReport, e);
        }
    }
}
