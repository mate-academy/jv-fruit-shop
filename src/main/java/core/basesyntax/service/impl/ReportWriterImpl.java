package core.basesyntax.service.impl;

import core.basesyntax.repository.FruitStorage;
import core.basesyntax.service.WriterService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportWriterImpl implements WriterService {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";
    @Override
    public void write(String fileName) {
        try (Writer writer = new FileWriter(fileName)) {
            writer.append(HEADER).append(System.lineSeparator());
            for (Map.Entry<String, Integer> entry : FruitStorage.fruitsOnStock.entrySet()) {
                writer.append(entry.getKey())
                        .append(COMMA)
                        .append(String.valueOf(entry.getValue()))
                        .append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName);
        }
    }
}
