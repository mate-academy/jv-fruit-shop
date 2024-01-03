package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;

public class StoreWriteToFileCsvImpl implements StoreWriteToFileCsv {
    public static final String FILE_NAME = "ReportFile";
    @Override
    public void writeToCsv(String data) {
        try {
            Files.writeString(Path.of(FILE_NAME), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file");
        }

    }

    public String convertToCSV(Map<String, Integer> report) {
        String[] header = new String[]{"fruit", "quantity"};
        StringBuilder builder = new StringBuilder();
        report.forEach((fruit, quantity) -> builder.append(fruit).append(",").append(quantity));
        return builder.toString();
    }
}
