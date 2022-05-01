package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ValidationService;
import java.util.ArrayList;
import java.util.List;

public class CsvParserService implements ParserService {
    private static final String SPLITERATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final ValidationService validationService;

    public CsvParserService() {
        this.validationService = new FruitTransactionValidator();
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
        FruitTransaction transaction = new FruitTransaction();
        FruitTransaction.Operation operation =
                FruitTransaction.Operation.getOperationByAlias(data[OPERATION_INDEX]);
        Fruit fruit = new Fruit(data[FRUIT_INDEX]);
        int quantity = Integer.parseInt(data[QUANTITY_INDEX]);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
