package core.basesyntax.service.impl;

import core.basesyntax.model.FruitReport;
import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterImpl implements Writer {

    private static final String SEPARATOR = System.lineSeparator();

    @Override
    public void writeInFile(List<FruitReport> dataforReport, String filePath) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity");
        for (FruitReport data : dataforReport) {
            builder.append(SEPARATOR)
                    .append(data.getFruit())
                    .append(",")
                    .append(data.getQuantity());
        }
        String reportData = builder.toString();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(reportData);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
