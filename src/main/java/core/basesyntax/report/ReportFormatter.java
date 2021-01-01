package core.basesyntax.report;

import core.basesyntax.reader.DataReader;

public interface ReportFormatter {
    String createReport(DataReader dataReader);

    void createReportInFile(DataReader dataReader, String fileName);
}
