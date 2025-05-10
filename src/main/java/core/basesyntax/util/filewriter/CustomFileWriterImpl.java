package core.basesyntax.util.filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class CustomFileWriterImpl implements CustomFileWriter {
    @Override
    public void write(String resultingReport, String filePath) {
        try (java.io.FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(resultingReport);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file: " + filePath, e);
        }
    }
}
