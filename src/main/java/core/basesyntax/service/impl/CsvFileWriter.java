package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriter implements FruitFileWriter {
    private static final String SEPARATOR = ",";
    private static final String UP_CASE = "fruit,quantity";

    @Override
    public void createReportFile(Map<Fruit, Integer> base, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(UP_CASE + System.lineSeparator());
            for (Map.Entry<Fruit, Integer> entry : base.entrySet()) {
                writer.write(entry.getKey().getFruitName()
                        + SEPARATOR + entry.getValue() + System.lineSeparator());
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Problem to write information to file.", e);
        }
    }
}

