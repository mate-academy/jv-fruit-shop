package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterCvsImpl implements FileWriter {

    @Override
    public void write(String path, String text) {
        try (BufferedWriter buf = new BufferedWriter(new java.io.FileWriter(path, false))) {
            buf.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file by path: " + path, e);
        }
    }
}
