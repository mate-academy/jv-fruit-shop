package core.basesyntax.storage;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionStorage {
    private static List<FruitTransaction> transactions = new ArrayList<>();

    public static List<FruitTransaction> accessTS() {
        return transactions;
    }
}

