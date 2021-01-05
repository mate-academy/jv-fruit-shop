package core.basesyntax.report;

import core.basesyntax.dao.interfaces.MyFileReader;

public interface ReportCreator {
    String createReport(MyFileReader data);
}
