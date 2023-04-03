package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionsProcessor;
import core.basesyntax.strategy.BiFunctionSupplier;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;

public class TransactionsProcessorImpl implements TransactionsProcessor
        <Map<Fruit, List<Transaction>>, Storage> {
    private Storage storage;

    @Override
    public Storage process(Map<Fruit, List<Transaction>> transactionsData) {
        storage = new Storage(getRemnants(transactionsData));
        transactionsData.forEach((key, value) -> storage.get()
                .put(key, getReportForOneFruit(value)));
        return storage;
    }

    private Map<Fruit, Integer> getRemnants(Map<Fruit, List<Transaction>> transactionsData) {
        return transactionsData.entrySet().stream()
                .flatMap(e -> e.getValue().stream())
                .filter(t -> t.getOperation().equals(Operation.BALANCE))
                .collect(Collectors.toMap(Transaction::getFruit, Transaction::getQuantity));
    }

    private int getReportForOneFruit(List<Transaction> transactionList) {
        int result = 0;
        ToIntBiFunction<Integer, Integer> biFunction;
        BiFunctionSupplier biFunctionSupplier = new BiFunctionSupplier();
        for (Transaction t : transactionList) {
            biFunction = biFunctionSupplier.getFunction(t.getOperation());
            result = biFunction.applyAsInt(result, t.getQuantity());
        }
        if (result < 0) {
            throw new RuntimeException("Something went wrong... The result for "
                    + transactionList.get(0).getFruit().getName()
                    + " is " + result);
        }
        return result;
    }
}
