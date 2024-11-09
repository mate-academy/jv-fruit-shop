package core.basesyntax.dao;

import core.basesyntax.model.Apple;
import core.basesyntax.model.Banana;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReportImpl implements WriteReport {
    private Banana banana = new Banana();
    private Apple apple = new Apple();

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
