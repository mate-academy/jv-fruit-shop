package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements Writer {
    @Override
    public void write(String filename, String report) {
        File resultFile = new File(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Could not write in file " + filename, e);
        }
    }
}
