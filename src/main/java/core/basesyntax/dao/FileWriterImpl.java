package core.basesyntax.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class FileWriterImpl implements core.basesyntax.dao.FileWriter {
    private static final String PIVOT_FILE_NAME = "src/main/resources/pivot.csv";

    @Override
    public void writeToFile(String report) {
        Path filePath = Path.of(PIVOT_FILE_NAME);
        try (FileWriter fileWriter = new FileWriter(filePath.toFile());
                PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.printf(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + PIVOT_FILE_NAME, e);
        }
    }
}
