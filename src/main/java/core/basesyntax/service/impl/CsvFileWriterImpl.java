package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvFileWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterImpl implements CsvFileWriter {
    private static final String COMMA = ",";

    @Override
    public void reportFile(Map<Fruit, Integer> fruitReport, String filePath) {
        try (FileWriter writerToFile = new FileWriter(filePath)) {
            for (Map.Entry<Fruit, Integer> entry : fruitReport.entrySet()) {
                writerToFile.append(entry.getKey().getName()).append(COMMA)
                        .append(String.valueOf(entry.getValue())).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file", e);
        }
    }
}
