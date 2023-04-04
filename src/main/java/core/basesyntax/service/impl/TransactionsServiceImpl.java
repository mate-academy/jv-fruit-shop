package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionsService;
import core.basesyntax.strategy.BiFunctionSupplier;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionsServiceImpl implements TransactionsService
        <Map<Fruit, List<Transaction>>, Storage> {
    private static final int ZERO_INDEX = 0;
    private Storage storage;

    @Override
    public Storage process(Map<Fruit, List<Transaction>> transactionsData) {
        storage = new Storage(getRemnants(transactionsData));
        transactionsData.forEach((key, value) -> storage.get()
                .put(key, getReportForOneFruit(value, storage.get().get(key))));
        return storage;
    }

    private Map<Fruit, Integer> getRemnants(Map<Fruit, List<Transaction>> transactionsData) {
        return transactionsData.entrySet().stream()
                .flatMap(e -> e.getValue().stream())
                .filter(t -> t.getOperation().equals(Operation.BALANCE))
                .collect(Collectors.toMap(Transaction::getFruit, Transaction::getQuantity));
    }

    private int getReportForOneFruit(List<Transaction> transactionList, int remnant) {
        final int[] result = {remnant};
        BiFunctionSupplier biFunctionSupplier = new BiFunctionSupplier();
        transactionList.stream()
                .filter(t -> !t.getOperation().equals(Operation.BALANCE))
                .forEach(t -> result[ZERO_INDEX] = biFunctionSupplier
                        .getFunction(t.getOperation())
                        .applyAsInt(result[ZERO_INDEX], t.getQuantity()));
        if (result[ZERO_INDEX] < 0) {
            throw new RuntimeException("Something went wrong... The result for "
                    + transactionList.get(ZERO_INDEX).getFruit().getName()
                    + " is " + result[ZERO_INDEX]);
        }
        return result[ZERO_INDEX];
    }
}
