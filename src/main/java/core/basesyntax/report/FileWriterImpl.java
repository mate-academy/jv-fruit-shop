package core.basesyntax.report;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String report, String fileName) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Path.of(fileName));
            writer.write(report);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can not write to file: " + fileName, e);
        }
    }
}
