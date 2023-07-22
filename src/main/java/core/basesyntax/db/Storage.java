package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class Storage {
    private static List<FruitTransaction> fruitTransactions;

    public static List<FruitTransaction> getFruitTransactions() {
        return fruitTransactions;
    }

    public static void setFruitTransactions(List<FruitTransaction> fruitTransactions) {
        Storage.fruitTransactions = fruitTransactions;
    }
}
