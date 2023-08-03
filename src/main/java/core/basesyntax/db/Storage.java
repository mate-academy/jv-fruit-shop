package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static List<FruitTransaction> transactions = new ArrayList<>();
    private static HashMap<String, Integer> report = new HashMap<>();

    public static List<FruitTransaction> getTransactions() {
        return transactions;
    }

    public static void setTransactions(List<FruitTransaction> transactions) {
        Storage.transactions = transactions;
    }

    public static HashMap<String, Integer> getReport() {
        return report;
    }

    public static void setReport(HashMap<String, Integer> report) {
        Storage.report = report;
    }
}
