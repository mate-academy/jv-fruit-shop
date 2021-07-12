package core.basesyntax.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReportsDaoImpl implements ReportsDao {
    private static final String SEPARATOR = ",";
    private static final String FILE_HEADER = "type,fruit,quantity";

    @Override
    public void saveReport(Map<String, Integer> transactionsMap, String reportFilename) {
        File toFile = new File(reportFilename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toFile))) {
            writer.write(FILE_HEADER + System.lineSeparator());
            transactionsMap.forEach((k, v) -> {
                try {
                    writer.write(k + SEPARATOR + v + System.lineSeparator());
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
        File fromFile = new File(sourceFilename);
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFile))) {
            String line = reader.readLine();
            if (!line.equals(FILE_HEADER)) {
                throw new IllegalArgumentException("Input file has incorrect heading. "
                    + "Expected - " + FILE_HEADER + ", provided - " + line);
            }
            line = reader.readLine();
            List<String> rawRecords = new LinkedList<>();
            while (line != null) {
                rawRecords.add(line);
                line = reader.readLine();
            }
            return rawRecords;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fromFile + " for reading", e);
        }
    }
}

