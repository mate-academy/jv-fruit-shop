package core.basesyntax.transactions;

import java.util.List;

public class FruitTransactions {
    private final List<List<String>> transactions;

    public FruitTransactions(List<List<String>> transactions) {
        this.transactions = transactions;
    }

    public List<List<String>> getTransactions() {
        return transactions;
    }
}
