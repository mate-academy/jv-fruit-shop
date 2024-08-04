package core.basesyntax.report.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements Writer {
    @Override
    public void write(String resultingReport, String pathFile) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(pathFile)
        )) {
            writer.write(resultingReport);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
