package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface ReportGenerator {
    List<String> createReport(Map<String, Integer> fruitTransactionDtoList);
}
