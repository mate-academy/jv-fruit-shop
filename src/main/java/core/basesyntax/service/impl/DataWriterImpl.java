package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriterImpl implements DataWriter {
    private static final String FIRST_LINE = "Fruit,Value";
    private static final int FRUIT_INDEX = 0;
    private static final int QUANTITY_INDEX = 1;

    @Override
    public void writeData(String report, String toFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toFile))) {
            writer.write(FIRST_LINE);
            writer.newLine();
            String[] lines = report.split(System.lineSeparator());
            for (String line : lines) {
                String[] fields = line.split(",");
                writer.write(fields[FRUIT_INDEX] + ","
                        + Integer.parseInt(fields[QUANTITY_INDEX]));
                writer.newLine();
            }
            System.out.println("Data successfully written to " + toFile);
        } catch (IOException e) {
            throw new RuntimeException("Can't wrote report to file" + toFile, e);
        }
    }
}
