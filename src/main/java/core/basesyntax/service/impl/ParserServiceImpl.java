package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;

import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> fileData) {
        return fileData.stream()
                .map(line -> line.split(SEPARATOR))
                .map(transaction ->
                        new FruitTransaction(FruitTransaction.Operation.getOperation(transaction[OPERATION_INDEX].trim()),
                                new Fruit(transaction[PRODUCT_INDEX].trim()),
                                Integer.parseInt(transaction[QUANTITY_INDEX].trim()))
                )
                .collect(Collectors.toList());
    }
}
