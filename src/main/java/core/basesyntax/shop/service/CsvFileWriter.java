package core.basesyntax.shop.service;

import core.basesyntax.shop.model.Fruit;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvFileWriter implements FileWriter {
    private static final String STOCK_BALANCE_HEADER = "fruit,quantity" + System.lineSeparator();

    public void createReportFileNew(Map<Fruit, Integer> fruitReport, String filePath) {
        Path file = Path.of(filePath);
        List<String> lines = fruitReport.entrySet().stream()
                .map(entry -> entry.getKey().getType() + "," + entry.getValue())
                .collect(Collectors.toList());
        try {
            Files.writeString(file, STOCK_BALANCE_HEADER);
            Files.write(file, lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + filePath, e);
        }
    }

    @Override
    public void createReportFile(Map<Fruit, Integer> fruitReport, String filePath) {
        try (Writer writer = new java.io.FileWriter(filePath)) {
            writer.append("fruit").append(',').append("quantity").append(System.lineSeparator());
            for (Map.Entry<Fruit, Integer> entry : fruitReport.entrySet()) {
                writer.append(entry.getKey().getType())
                        .append(',')
                        .append(entry.getValue().toString())
                        .append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + filePath, e);
        }
    }
}
