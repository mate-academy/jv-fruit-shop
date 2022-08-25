package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class CsvFileWriterImpl implements FileWriter {
    @Override
    public void writeReport(String toFile, String report) {
        try {
            File reportFile = new File(toFile);
            reportFile.createNewFile();
            BufferedWriter reportWriter = new BufferedWriter(new java.io.FileWriter(reportFile));
            reportWriter.write(report);
            reportWriter.flush();
            reportWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file: " + toFile, e);
        }
    }
}
