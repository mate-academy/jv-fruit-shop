package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    @Override
    public void write(String toWrite, String toFile) {
        if (toWrite == null || toFile == null) {
            throw new RuntimeException("You shouldn't pass null for function");
        }
        File file = new File(toFile);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(toWrite);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + toWrite, e);
        }
    }
}
