package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_PRODUCT_NAME = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseTransaction(List<String> transactions) {
        return transactions.stream()
                .map(t -> {
                    String[] tokens = t.split(SEPARATOR);
                    return new FruitTransaction(
                            FruitTransaction.Operation.getByCode(tokens[INDEX_OF_OPERATION]),
                            tokens[INDEX_OF_PRODUCT_NAME],
                            Integer.parseInt(tokens[INDEX_OF_AMOUNT])
                    );
                })
                .collect(Collectors.toList());
    }
}
