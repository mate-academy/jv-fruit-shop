package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_PRODUCT_NAME = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private static final String SEPARATOR = ",";
    private static final Map<String, FruitTransaction.Operation> STRING_OPERATION_MAP = Map.of(
            "b", FruitTransaction.Operation.BALANCE,
            "s", FruitTransaction.Operation.SUPPLY,
            "p", FruitTransaction.Operation.PURCHASE,
            "r", FruitTransaction.Operation.RETURN);

    @Override
    public List<FruitTransaction> parseTransaction(List<String> transactions) {
        return transactions.stream()
                .map(t -> new FruitTransaction(
                        STRING_OPERATION_MAP.get(t.split(SEPARATOR)[INDEX_OF_OPERATION]),
                        t.split(SEPARATOR)[INDEX_OF_PRODUCT_NAME],
                        Integer.parseInt(t.split(SEPARATOR)[INDEX_OF_AMOUNT])))
                .collect(Collectors.toList());
    }
}
