package core.basesyntax.report;

import core.basesyntax.workwithfiles.DataReader;

public interface ReportFormatter {
    String createReport(DataReader dataReader);
}
