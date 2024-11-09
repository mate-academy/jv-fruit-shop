package core.basesyntax.writer.impl;

import core.basesyntax.writer.Writer;
import java.io.BufferedWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    private static final String SPLIT_GAP = " ";

    @Override
    public void write(String report, String path) {
        String[] split = report.split(SPLIT_GAP);
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(path))) {
            for (String s : split) {
                writer.write(s);
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
