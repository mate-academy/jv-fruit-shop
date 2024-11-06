package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements Writer {
    @Override
    public void writeToFile(String resultingReport, String path) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(resultingReport);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file by path " + path, e);
        }
    }
}
