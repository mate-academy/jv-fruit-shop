package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileReporting;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileReportingImpl implements FileReporting {

    @Override
    public List<String> getReport(Map<Fruit, Integer> fruits) {
        List<String> report = fruits.entrySet().stream()
                .map(s -> s.getKey() + "," + s.getValue())
                .collect(Collectors.toList());
        report.add(0, "fruit,quantity");
        return report;
    }
}
