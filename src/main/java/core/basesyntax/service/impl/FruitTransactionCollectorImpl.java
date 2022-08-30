package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionCollector;
import core.basesyntax.service.FruitTransactionService;

import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionCollectorImpl implements FruitTransactionCollector {
    FruitTransactionService transactionService = new FruitTransactionServiceImpl();

    @Override
    public List<FruitTransaction> collectFruitTransactions(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(transactionService::createNewFruitTransaction)
                .collect(Collectors.toList());
    }
}
