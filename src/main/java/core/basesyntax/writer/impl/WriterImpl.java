package core.basesyntax.writer.impl;

import core.basesyntax.writer.Writer;
import java.io.BufferedWriter;
import java.io.IOException;

public class WriterImpl implements Writer {

    @Override
    public void write(String report, String path) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(path))) {
            writer.write(report);
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
