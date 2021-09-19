package core.service.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OperationWriterImpl implements OperationWriter {
    @Override
    public void write(String report, String filePath) {
        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(report + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("File wasn't written!");
        }
    }
}
