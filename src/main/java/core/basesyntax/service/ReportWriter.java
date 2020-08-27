package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ReportWriter {
    public static final Path GENERATED_PATH = Path.of("src/test/out/test.csv");

    public String getReport(String filePath) {
        StorageService executor = new StorageService();
        executor.storageWriter(filePath);
        List<String> report = executor.printReport();
        StringBuilder forTest = new StringBuilder();

        if (!report.isEmpty()) {
            try {
                Files.deleteIfExists(GENERATED_PATH);
                Files.createFile(GENERATED_PATH);
                for (String line : report) {
                    Files.writeString(GENERATED_PATH, line + "\n", StandardOpenOption.APPEND);
                    forTest.append(line).append("\n");
                }
            } catch (IOException e) {
                throw new RuntimeException("Can't write file");
            }
        }
        return forTest.toString().trim();
    }
}
