package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvFileWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterImpl implements CsvFileWriter {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String COMA = ",";

    @Override
    public void writeData(String toFileName) {
        try (FileWriter fileWriter = new FileWriter(new File(toFileName))) {
            StringBuilder builder = new StringBuilder();
            builder.append(FIRST_LINE);

            for (Map.Entry<Fruit, Integer> entry : Storage.fruitsMap.entrySet()) {
                builder.append(System.lineSeparator())
                        .append(entry.getKey().getName())
                        .append(COMA)
                        .append(entry.getValue());
            }
            fileWriter.write(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data from the file " + toFileName, e);
        }
    }
}
