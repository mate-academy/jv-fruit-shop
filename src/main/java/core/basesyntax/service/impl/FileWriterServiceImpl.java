package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String COMMA_SEPARATOR = ",";
    private static final String REPORT_HEAD = "fruit,quantity";

    @Override
    public void writeToFile(String toFilePath, Map<Fruit, Integer> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REPORT_HEAD).append(LINE_SEPARATOR);
        String reportBody =
                storage.keySet().stream()
                        .map(fruit -> fruit.getName() + COMMA_SEPARATOR + storage.get(fruit))
                        .collect(Collectors.joining(LINE_SEPARATOR));
        stringBuilder.append(reportBody);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toFilePath))) {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException("Report was not written: " + toFilePath);
        }
    }
}
