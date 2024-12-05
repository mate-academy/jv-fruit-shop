package core.basesyntax;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements MyFileWriter {
    @Override
    public void write(String report, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write file: " + path, e);
        }
    }
}
