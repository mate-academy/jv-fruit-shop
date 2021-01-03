package core.basesyntax;

import core.basesyntax.exception.CsvFileException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalCsvFileWriter implements CsvFileWriter {
    private static final Logger logger = LoggerFactory.getLogger(LocalCsvFileWriter.class);
    private static final String STOCK_BALANCE_HEADER = "fruit,quantity" + System.lineSeparator();
    private final String filePath;

    public LocalCsvFileWriter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void createStockFile(Map<String, Integer> stockBalance) {
        Path file = Path.of(filePath);
        List<String> lines = stockBalance.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());
        try {
            Files.writeString(file, STOCK_BALANCE_HEADER);
            Files.write(file, lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new CsvFileException("Can't write file", e);
        }
    }
}
