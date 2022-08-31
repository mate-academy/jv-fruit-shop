package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {

    @Override
    public void write(String report, String path) {
        File outputFile = new File(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile,
                true))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can not find the file" + outputFile, e);
        }
    }
}

