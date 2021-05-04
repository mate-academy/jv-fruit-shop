package core.basesyntax.files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class FileWriterImpl implements FileWriter {
    private static final String SEPARATOR = System.lineSeparator();
    private static final String WORD_SEPARATOR = ",";

    @Override
    public void createReport(Map<String, Integer> report, String path) {
        StringBuilder dataReport = new StringBuilder("fruit,quantity");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(path))) {
            for (Map.Entry<String, Integer> entry : report.entrySet()) {
                dataReport.append(SEPARATOR)
                        .append(entry.getKey())
                        .append(WORD_SEPARATOR)
                        .append(entry.getValue());
            }
            bufferedWriter.write(dataReport.toString());
        } catch (IOException e) {
            throw new RuntimeException("Path to file is incorrect");
        }
    }
}
