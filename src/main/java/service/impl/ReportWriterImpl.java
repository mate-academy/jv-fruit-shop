package service.impl;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import service.ReportWriter;

public class ReportWriterImpl implements ReportWriter {

    @Override
    public void writeReport(String report, String toFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toFileName))) {
            writer.write(report);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cannot find " + toFileName + " file", e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to" + toFileName + " file", e);
        }
    }
}
