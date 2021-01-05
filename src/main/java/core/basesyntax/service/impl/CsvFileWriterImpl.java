package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvFileWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterImpl implements CsvFileWriter {
    private static final String SYMBOL = ",";
    private static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public void writeData(String toFileName) {
        try (FileWriter writer = new FileWriter(new File(toFileName))) {
            StringBuilder sb = new StringBuilder();
            sb.append(REPORT_HEADER);
            sb.append(System.lineSeparator());
            for (Map.Entry<Fruit, Integer> fruit: Storage.fruits.entrySet()) {
                sb.append(fruit.getKey().getName());
                sb.append(SYMBOL);
                sb.append(fruit.getValue());
                sb.append(System.lineSeparator());
            }
            writer.write(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data from the file " + toFileName, e);
        }
    }
}
