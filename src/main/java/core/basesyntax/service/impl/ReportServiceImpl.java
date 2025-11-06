package core.basesyntax.service.impl;

import core.basesyntax.ReportGenerator;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private final ReportGenerator reportGenerator;

    public ReportServiceImpl(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public String createReport(List<FruitTransaction> fileData) {
        return this.reportGenerator.generate(fileData);
    }
}
