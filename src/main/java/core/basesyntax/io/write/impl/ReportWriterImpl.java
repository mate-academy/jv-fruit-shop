package core.basesyntax.io.write.impl;

import core.basesyntax.io.write.ReportWriter;

public class ReportWriterImpl implements ReportWriter {
    private final ReportWriter writer;

    public ReportWriterImpl(ReportWriter writer) {
        this.writer = writer;
    }

    @Override
    public void write(String report, String reportPath) {
        writer.write(report, reportPath);
    }
}
