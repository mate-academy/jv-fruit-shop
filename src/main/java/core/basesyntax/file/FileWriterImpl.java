package core.basesyntax.file;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String resultingReport, String filePath) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new java.io.FileWriter(filePath, false))) {
            bufferedWriter.write(resultingReport);
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }

    }
}
