package core.basesyntax.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class FileWriterImpl implements core.basesyntax.dao.FileWriter {
    @Override
    public void writeToFile(String pathToFile, String report) {
        Path filePath = Path.of(pathToFile);
        try (FileWriter fileWriter = new FileWriter(filePath.toFile());
                PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.printf(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + pathToFile, e);
        }
    }
}
