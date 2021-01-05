package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

public class CsvFileWriterImpl implements FileWriter {
    public static String FRUIT = "fruit";
    public static String QUANTITY = "quantity";
    public static String COMMA = ",";
    public static String LINE_SEPARATOR = "\n";

    @Override
    public void writeDataInFile(Map<String, Long> report, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            StringBuilder sb = new StringBuilder();
            sb.append(FRUIT);
            sb.append(COMMA);
            sb.append(QUANTITY);
            sb.append(LINE_SEPARATOR);
            for (Map.Entry<String, Long> entry : report.entrySet()) {
                sb.append(entry.getKey())
                        .append(COMMA)
                        .append(entry.getValue())
                        .append(LINE_SEPARATOR);
            }
            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found " + fileName);
        }
    }
}
