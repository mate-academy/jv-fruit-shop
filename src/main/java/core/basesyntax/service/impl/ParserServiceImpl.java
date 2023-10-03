package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private FruitTransaction.Operation getOperation(String operationCode) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getOperationType().equals(operationCode)) {
                return operation;
            }
        }
        throw new RuntimeException("No operation was found: " + operationCode);
    }

    @Override
    public List<FruitTransaction> parseTransactions(List<String> fileData) {
        return fileData.stream()
                .map(s -> s.split(","))
                .map(transaction ->
                        new FruitTransaction(getOperation(transaction[0].trim()),
                                new Fruit(transaction[1].trim()),
                                Integer.parseInt(transaction[2].trim()))
                )
                .collect(Collectors.toList());
    }
}
