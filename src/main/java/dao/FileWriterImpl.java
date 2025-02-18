package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileWriterImpl implements CsvFileWriter {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final String NEW_LINE = System.lineSeparator();

    @Override
    public void writeFile(String fileName, Map<String, Integer> inventory) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(HEADER).append(NEW_LINE);

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(NEW_LINE);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(reportBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file " + fileName, e);
        }
    }
}
