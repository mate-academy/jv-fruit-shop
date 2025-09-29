package core.basesyntax.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String reportGenerator, File output) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(output))) {
            bufferedWriter.write(reportGenerator);
        } catch (IOException e) {
            throw new RuntimeException("can't reach file " + output, e);
        }
    }
}
