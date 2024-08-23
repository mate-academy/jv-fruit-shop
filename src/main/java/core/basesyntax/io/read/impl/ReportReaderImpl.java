package core.basesyntax.io.read.impl;

import core.basesyntax.io.read.ReportReader;

import java.io.FileNotFoundException;

public class ReportReaderImpl implements ReportReader {
    private final ReportReader reader;

    public ReportReaderImpl(ReportReader reader) {
        this.reader = reader;
    }

    public String readReport() throws FileNotFoundException {
        return reader.readReport();
    }
}
