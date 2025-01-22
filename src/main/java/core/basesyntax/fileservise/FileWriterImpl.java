package core.basesyntax.fileservise;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeFile(String report, String nameOfNewFile) {
        try (BufferedWriter bufferedWriter
                     = new BufferedWriter(new java.io.FileWriter(nameOfNewFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
