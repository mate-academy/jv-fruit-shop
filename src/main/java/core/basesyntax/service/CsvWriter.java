package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CsvWriter {
    private static final DateTimeFormatter FORMATTED = DateTimeFormatter.ofPattern(
            "yyyy-MM-dd_HH-mm-ss");

    public void writeToFile(String outputPath, String report) {
        outputPath += LocalDateTime.now().format(FORMATTED) + ".csv";
        File fileWithReport = new File(outputPath);

        try {
            fileWithReport.createNewFile();
            Files.writeString(Path.of(outputPath), report, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write report to file", e);
        }
    }
}
