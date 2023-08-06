package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvDataWriterServiceImpl implements DataWriterService {
    private static final int FRUIT_INDEX = 0;
    private static final int QUANTITY_INDEX = 1;

    @Override
    public void writeToFile(String toFileName, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toFileName))) {
            String[] lines = report.split(System.lineSeparator());
            for (String line : lines) {
                String[] parts = line.split(",");
                int value = Integer.parseInt(parts[QUANTITY_INDEX]);
                if (value < 0) {
                    throw new IllegalArgumentException("Value " + value + " for fruit "
                            + parts[FRUIT_INDEX] + " is invalid!");
                }
            }
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file", e);
        }
    }
}
