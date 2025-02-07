package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface ReportGenerator {
    List<String> getReport(Map<String, Integer> fruitRepository);

}
