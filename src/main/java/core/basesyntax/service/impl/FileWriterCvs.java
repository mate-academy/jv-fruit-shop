package core.basesyntax.service.impl;

import core.basesyntax.service.IFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterCvs implements IFileWriter {

    @Override
    public void write(String path, String text) {
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(path, false))) {
            buf.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + path, e);
        }
    }
}
