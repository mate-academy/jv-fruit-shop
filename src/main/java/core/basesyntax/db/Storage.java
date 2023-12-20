package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<FruitTransaction> dataStorage = new ArrayList<>();

    public static List<FruitTransaction> getDataStorage() {
        return dataStorage;
    }
}
