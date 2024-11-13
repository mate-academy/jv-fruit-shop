package core.basesyntax.dao;

import core.basesyntax.Main;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {
    private Main main = new Main();

    @Override
    public void writeReport(String nameOfFileToReport) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfFileToReport))) {
            writer.write("fruit,quantity" + System.lineSeparator());
            writer.write("banana, " + main.getBanana().getBalance() + System.lineSeparator());
            writer.write("apple, " + main.getApple().getBalance() + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file in direction: " + nameOfFileToReport, e);
        }
    }
}
