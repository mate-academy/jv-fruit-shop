package core.basesyntax;


import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String resultingReport, String toFileName) {
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(toFileName)) {
            fileWriter.write(resultingReport);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
