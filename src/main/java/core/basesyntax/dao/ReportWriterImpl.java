package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static core.basesyntax.Main.apple;
import static core.basesyntax.Main.banana;

public class ReportWriterImpl implements ReportWriter {

    @Override
    public void writeReport(String nameOfFileToReport) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfFileToReport))) {
            writer.write("fruit,quantity" + System.lineSeparator());
            writer.write("banana, " + banana.getBalance() + System.lineSeparator());
            writer.write("apple, " + apple.getBalance() + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file in direction: " + nameOfFileToReport, e);
        }
    }
}
