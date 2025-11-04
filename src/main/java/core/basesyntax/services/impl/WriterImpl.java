package core.basesyntax.services.impl;

import core.basesyntax.services.Writer;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    @Override
    public boolean write(String text, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(text);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + fileName + e);
        }
    }
}
