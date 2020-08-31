package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvFileWriter implements FileWriter {
    private static final String STOCK_BALANCE_HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public void createReportFile(Map<String, Long> stockBalance, String filePath) {
        Path file = Path.of(filePath);
        List<String> lines = stockBalance.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());
        try {
            Files.writeString(file, STOCK_BALANCE_HEADER);
            Files.write(file, lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file", e);
        }
    }
}
