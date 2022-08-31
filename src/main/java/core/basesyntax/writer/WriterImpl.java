package core.basesyntax.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {

    @Override
    public void write(String data, String toFile) {
        File outputFile = new File(toFile);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to the file:" + toFile, e);
        }
    }
}
