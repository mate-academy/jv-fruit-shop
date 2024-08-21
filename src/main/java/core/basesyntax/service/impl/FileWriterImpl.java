package core.basesyntax.service.impl;

import core.basesyntax.service.ReportFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements ReportFileWriter {

    @Override
    public void write(String report, String pathToFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can not write to file " + pathToFile);
        }
    }
}
