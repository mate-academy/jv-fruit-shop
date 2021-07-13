package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

public class ReportsDaoImpl implements ReportsDao {
    private static final String SEPARATOR = ",";
    private static final String FILE_HEADER = "type,fruit,quantity";

    @Override
    public void saveReport(Map<String, Integer> transactionsMap, String reportFilename) {
        if (transactionsMap == null) {
            throw new IllegalArgumentException("Obtained corrupted data for writing");
        }
        File toFile = new File(reportFilename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toFile))) {
            writer.write(FILE_HEADER);
            transactionsMap.forEach((k, v) -> {
                try {
                    writer.write(System.lineSeparator() + k + SEPARATOR + v);
                } catch (IOException e) {
                    throw new RuntimeException("Line " + k + SEPARATOR + v
                            + " cannot be written to file " + reportFilename, e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("Can't open file " + reportFilename + " for writing ", e);
        }
    }

    @Override
    public List<String> getRawRecords(String sourceFilename) {
        try {
            return Files.readAllLines(new File(sourceFilename).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't open file " + sourceFilename + " for reading", e);
        }
    }
}
