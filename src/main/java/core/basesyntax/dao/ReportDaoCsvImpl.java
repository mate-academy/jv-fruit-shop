package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportDaoCsvImpl implements ReportDao {
    private static final String CSV_SEPARATOR = ",";

    @Override
    public void saveReport(Map<String, Integer> data, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            bufferedWriter.write("fruit,quantity" + System.lineSeparator());
            bufferedWriter.write(data.keySet().stream()
                    .map(k -> k + CSV_SEPARATOR + data.get(k))
                    .collect(Collectors.joining(System.lineSeparator())));
        } catch (IOException e) {
            throw new RuntimeException("File not found " + fileName);
        }
    }
}
