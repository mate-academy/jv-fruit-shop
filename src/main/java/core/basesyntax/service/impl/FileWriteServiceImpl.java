package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileWriteServiceImpl implements FileWriterService {
    private static final String FIRST_LINE_IN_REPORT = "fruit,quantity";
    private static final String OUTPUT_FILE =
            "/Users/macbook/IdeaProjects/jv-fruit-shop/src/main/resources/fileReport.csv";

    @Override
    public void writeReport(Map<String, Integer> fruitsTransactionMap) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            bufferedWriter.write(FIRST_LINE_IN_REPORT + System.lineSeparator());
            fruitsTransactionMap.forEach((k, v) -> {
                try {
                    bufferedWriter.write(k + "," + v + System.lineSeparator());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("Can't write information into the file " + OUTPUT_FILE);
        }
    }
}
