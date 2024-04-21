package core.basesyntax.service.impl;

import core.basesyntax.dao.TransactionStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.Optional;

public class ParserServiceImpl implements ParserService {
    private static final int CODE_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private static final String SEPARATOR = ",";

    private TransactionStorageDao transactionStorageDao;

    public ParserServiceImpl(TransactionStorageDao transactionStorageDao) {
        this.transactionStorageDao = transactionStorageDao;
    }

    @Override
    public void parse(List<String> rawData) {
        for (String element : rawData) {
            String[] parts = element.split(SEPARATOR);
            Optional<FruitTransaction.Operation> operation = FruitTransaction.Operation
                    .fromString(parts[CODE_POSITION]);
            if (operation.isEmpty()) {
                continue;
            }
            String fruit = parts[FRUIT_POSITION];
            int quantity = Integer.parseInt(parts[QUANTITY_POSITION]);
            operation.ifPresent(value -> transactionStorageDao
                    .add(new FruitTransaction(value, fruit, quantity)));
        }
    }
}
