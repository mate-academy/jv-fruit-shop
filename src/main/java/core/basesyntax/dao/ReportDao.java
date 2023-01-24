package core.basesyntax.dao;

import java.io.File;

public interface ReportDao {
    void writeReportToCsvFile(String report, File toFile);

}
