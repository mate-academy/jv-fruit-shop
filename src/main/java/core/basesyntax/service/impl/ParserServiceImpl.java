package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ValidatorService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String SPLITERATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final ValidatorService validationService;

    public ParserServiceImpl(ValidatorService validationService) {
        this.validationService = validationService;
    }

    @Override
    public List<FruitTransaction> parse(List<String> records) {
        List<FruitTransaction> transactions = new ArrayList<>();
        validationService.isValid(records);

        for (String record : records) {
            transactions.add(initializeTransaction(record));
        }
        return transactions;
    }

    private FruitTransaction initializeTransaction(String record) {
        String[] data = record.split(SPLITERATOR);
        FruitTransaction.Operation operation =
                FruitTransaction.Operation.getOperationByAlias(data[OPERATION_INDEX]);
        Fruit fruit = new Fruit(data[FRUIT_INDEX]);
        int quantity = Integer.parseInt(data[QUANTITY_INDEX]);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
