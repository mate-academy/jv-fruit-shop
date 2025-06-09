package core.basesyntax.service;

import core.basesyntax.dao.FruitStorage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class WriterReportToCsvImpl implements WriterReportToCsv {
    @Override
    public void writeReport(String outputFilePath) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity\n");

        for (Map.Entry<String, java.math.BigDecimal> entry : FruitStorage.storage.entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }
        try {
            Files.write(Path.of(outputFilePath), builder.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t to write report to file: " + outputFilePath, e);
        }
    }
}
