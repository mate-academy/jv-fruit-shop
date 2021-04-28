package core.basesyntax.fruitshop.report.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String TITLE = "fruit,quantity\n";

    @Override
    public void generateReport(String toFile, Map<String, Integer> storage) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(TITLE);
            for (Map.Entry<String, Integer> map : storage.entrySet()) {
                bufferedWriter.write(map.getKey() + ",");
                bufferedWriter.write(map.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find the file", e);
        }
    }
}
