package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriterService;
import java.util.List;

public class ReportWriterServiceConsole implements ReportWriterService {
    @Override
    public void writeReport(final List<String> report) {
        report.forEach(System.out::println);
    }
}
