package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.impl.service.ReportService;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String COMA_DELIMITER = ",";

    @Override
    public String getReport() {
        Set<Map.Entry<String, Integer>> entries = FruitStorage.FRUITS.entrySet();
        return entries.stream()
                .map(entry -> new StringBuilder().append(entry.getKey()).append(COMA_DELIMITER)
                        .append(entry.getValue()).append(System.lineSeparator()))
                .collect(Collectors.joining());
    }
}
