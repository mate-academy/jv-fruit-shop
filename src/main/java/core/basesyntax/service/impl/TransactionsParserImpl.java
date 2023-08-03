package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.interfaces.TransactionParser;
import core.basesyntax.service.interfaces.TransactionValidator;
import java.util.ArrayList;
import java.util.List;

public class TransactionsParserImpl implements TransactionParser<List<FruitTransaction>, String> {
    private static final int INDEX_OF_OPERATION_IN_RECORD = 0;
    private static final int INDEX_OF_FRUIT_IN_RECORD = 1;
    private static final int INDEX_OF_QUANTITY_IN_RECORD = 2;
    private static final String COMMA_DIVIDER = ",";

    private TransactionValidator validator;

    public TransactionsParserImpl(TransactionValidator validator) {
        this.validator = validator;
    }

    @Override
    public List<FruitTransaction> parse(String data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] records = data.split(System.lineSeparator());
        for (int i = 1; i < records.length; i++) {
            validator.validate(records[i]);
            fruitTransactions.add(valueOf(records[i]));
        }
        return fruitTransactions;
    }

    private static FruitTransaction valueOf(String record) {
        record = record.trim();
        String[] fields = record.split("COMMA_DIVIDER");
        Operation operation = Operation.fromCode(fields[INDEX_OF_OPERATION_IN_RECORD]);
        Fruit fruit = Fruit.valueOf(fields[INDEX_OF_FRUIT_IN_RECORD].toUpperCase());
        int quantity = Integer.parseInt(fields[INDEX_OF_QUANTITY_IN_RECORD]);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
