package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportDaoCsvImpl implements ReportDao {
    private static final String FILE_NAME = "report.csv";

    @Override
    public void saveReport(Map<String, Integer> data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bufferedWriter.write("fruit,quantity" + System.lineSeparator());
            String report = data.keySet().stream()
                    .map(k -> k + "," + data.get(k))
                    .collect(Collectors.joining(System.lineSeparator()));
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("File not found " + FILE_NAME);
        }
    }
}
