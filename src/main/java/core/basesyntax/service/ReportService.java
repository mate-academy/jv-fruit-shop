package core.basesyntax.service;

import core.basesyntax.model.Report;
import java.util.List;

public interface ReportService {
    void printReportsToFile(List<Report> reports, String filePath);
}
