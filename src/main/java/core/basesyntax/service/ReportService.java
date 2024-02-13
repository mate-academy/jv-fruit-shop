package core.basesyntax.service;

import core.basesyntax.dataprocess.DataProcessor;
import java.util.Map;

public interface ReportService {
    Map<String, Integer> generateReport(DataProcessor dataProcessor);
}
