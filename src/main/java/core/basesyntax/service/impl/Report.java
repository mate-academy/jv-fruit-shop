package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class Report {
    public static Map<Fruit, Integer> createReport() {
        return Storage.fruitsAndAmountsMap;
    }
}
