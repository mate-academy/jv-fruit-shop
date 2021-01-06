package core.basesyntax.service.impl;

import core.basesyntax.basesyntaxdb.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public Map<String, Long> getDefaultReport() {
        return Storage.fruitList.stream()
                .collect(Collectors.groupingBy(Fruit::getName, Collectors.counting()));
    }
}
