package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    @Override
    public void writerReportFile(String report, String pathFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Report cannot be write to file " + pathFile, e);
        }
    }
}
