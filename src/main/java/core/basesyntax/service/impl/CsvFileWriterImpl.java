package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

public class CsvFileWriterImpl implements FileWriter {
    @Override
    public void writeDataInFile(Map<String, Long> report, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            StringBuilder sb = new StringBuilder();
            sb.append("fruit");
            sb.append(",");
            sb.append("quantity");
            sb.append("\n");
            for (Map.Entry<String, Long> entry : report.entrySet()) {
                sb.append(entry.getKey())
                        .append(",")
                        .append(entry.getValue())
                        .append("\n");
            }
            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found " + fileName);
        }
    }
}
