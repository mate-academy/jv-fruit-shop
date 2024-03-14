package core.basesyntax.service.impl;

import core.basesyntax.model.Report;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.Writer;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final Writer writer = new WriterImpl();

    @Override
    public void printReportsToFile(List<Report> reports, String filePath) {
        for (Report report : reports) {
            String fullReport = report.header() + report.body();
            writer.writeToFolder(fullReport, filePath + report.typeName());
        }
    }
}
