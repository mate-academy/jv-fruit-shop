package core.basesyntax.service.impl.service;

import java.util.List;

public interface ReportService {
    String getReport(List<String> fruitsList, List<Integer> amounts);
}
