package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    @Override
    public void writeFruitsReport(String report, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Invalid file name :" + path, e);
        }

    }
}
