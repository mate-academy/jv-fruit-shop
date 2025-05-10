package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    private ReportGenerator reportGenerator;

    public WriterImpl(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    @Override
    public void createReport(String reportPath) {
        File report = new File(reportPath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportPath))) {
            writer.write(reportGenerator.generateReport());
        } catch (IOException e) {
            throw new RuntimeException("Unable to write to file: " + reportPath, e);
        }
    }
}
