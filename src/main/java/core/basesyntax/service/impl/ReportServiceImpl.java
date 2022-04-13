package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMNS = "fruit,quantity";
    private static final Function<Map<Fruit, Integer>, List<String>> FORMATTER =
            (map) -> map.entrySet().stream()
                    .map(e -> e.getKey() + "," + e.getValue())
                    .collect(Collectors.toList());

    @Override
    public List<String> makeReport(Map<Fruit, Integer> fruits) {
        List<String> report = FORMATTER.apply(fruits);
        report.add(0, COLUMNS);
        return report;
    }
}
