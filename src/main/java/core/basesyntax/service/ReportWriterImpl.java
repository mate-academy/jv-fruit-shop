package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public void writeReport(String fileName) {
        File report = new File(fileName);
        try(BufferedWriter reportWriter = new BufferedWriter(new FileWriter(report))) {
            //TODO

        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file: " + fileName, e);
        }
    }
}
