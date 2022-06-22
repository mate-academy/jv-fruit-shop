package db;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;

public class Storage {
    private static List<FruitTransaction> transactions = new ArrayList<>();

    public static List<FruitTransaction> getTransactions() {
        return transactions;
    }

    public static void setTransactions(List<FruitTransaction> transactions) {
        Storage.transactions = transactions;
    }
}
