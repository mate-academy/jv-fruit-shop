package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportFromData;
import java.util.stream.Collectors;

public class ReportFromDataImpl implements ReportFromData {
    public static final String TITLE_LINE = "fruit;quantity\n";

    @Override
    public String storageToString() {
        return TITLE_LINE + FruitStorage.FRUIT_STORAGE.entrySet().stream()
                .map(e -> e.getKey() + ";" + e.getValue().toString())
                .collect(Collectors.joining("\n"));
    }
}
