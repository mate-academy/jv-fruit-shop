package core.basesyntax.service.impl;

import core.basesyntax.service.ContentWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContentWriterImpl implements ContentWriter {
    @Override
    public void write(String report, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(fileName, true))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("File not found " + fileName, e);
        }
    }
}
