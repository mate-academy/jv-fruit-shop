package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public List<String> getReport(Map<String, Integer> fruitRepository) {
        return fruitRepository.entrySet().stream()
                .map(f -> f.getKey() + "," + f.getValue())
                .toList();
    }
}
