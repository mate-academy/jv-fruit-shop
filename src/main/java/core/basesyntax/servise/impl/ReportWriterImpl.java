package core.basesyntax.servise.impl;

import core.basesyntax.servise.ReportWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public File write(String report) {
        File file = new File("report.csv");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(report);
        } catch (
                IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        return file;
    }
}
