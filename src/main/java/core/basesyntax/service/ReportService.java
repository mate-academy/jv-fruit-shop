package core.basesyntax.service;

import core.basesyntax.dataprocess.DataProcessor;

public interface ReportService {
    String generateReport(DataProcessor dataProcessor);
}
