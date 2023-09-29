package core.basesyntax.service;

import java.util.Map;

public interface ReportService {
    String createFruitBalanceReport(Map<String, Integer> fruitBalance);
}
