package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Storage {
    private final Map<Fruit, List<Transaction>> transactionsData;

    private Storage(Map<Fruit, List<Transaction>> transactionsData) {
        this.transactionsData = transactionsData;
    }

    private static Map<Fruit, List<Transaction>> getTransactionsMap(
            List<Transaction> transactionList) {
        return transactionList.stream()
                .collect(Collectors.groupingBy(Transaction::getFruit));
    }

    public static Storage of(List<Transaction> transactionList) {
        return new Storage(getTransactionsMap(transactionList));
    }

    public Map<Fruit, List<Transaction>> getTransactionsData() {
        return transactionsData;
    }
}
