package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static List<FruitTransaction> transactions = new ArrayList<>();
    private static Map<String, Integer> fruits = new HashMap<>();

    public static List<FruitTransaction> getTransactions() {
        return transactions;
    }

    public static void setTransactions(List<FruitTransaction> transactions) {
        Storage.transactions = transactions;
    }

    public static Map<String, Integer> getFruits() {
        return fruits;
    }

    public static void setFruits(Map<String, Integer> fruits) {
        Storage.fruits = fruits;
    }
}
