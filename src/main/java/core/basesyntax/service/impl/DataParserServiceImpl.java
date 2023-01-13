package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataParserServiceImpl implements DataParserService {
    private static final String SEPARATOR = ",";
    private static final int TRANSACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int HEADER_INDEX = 0;

    @Override
    public List<FruitTransaction> toTransactions(List<String> fromFile) {
        Function<String, FruitTransaction> madeTransaction = line -> {
            String[] partsTransaction = line.split(SEPARATOR);
            String transaction = partsTransaction[TRANSACTION_INDEX];
            String fruit = partsTransaction[FRUIT_INDEX];
            int quantity = Integer.parseInt(partsTransaction[QUANTITY_INDEX]);
            return new FruitTransaction(FruitTransaction.Operation.getOperation(transaction),
                    fruit, quantity);
        };

        fromFile.remove(HEADER_INDEX);
        return fromFile.stream()
                .map(madeTransaction)
                .collect(Collectors.toList());
    }
}
