package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvFileWriterImpl implements CsvFileWriter {
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public void reportFile(Map<String, Long> balance, String filePath) {
        Path file = Path.of(filePath);
        List<String> listBalance = balance.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());
        try {
            Files.writeString(file, HEADER);
            Files.write(file, listBalance, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file! " + filePath);
        }
    }
}
