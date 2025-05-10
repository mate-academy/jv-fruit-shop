package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    public static final String TITLE_LINE = "fruit,quantity\n";

    @Override
    public String storageToString() {
        return TITLE_LINE + FruitStorage.FRUIT_STORAGE.entrySet().stream()
                .map(e -> e.getKey() + "," + e.getValue().toString())
                .collect(Collectors.joining("\n"));
    }
}
