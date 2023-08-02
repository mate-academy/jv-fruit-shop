package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.interfaces.TransactionParser;
import core.basesyntax.service.interfaces.TransactionValidator;
import java.util.ArrayList;
import java.util.List;

public class TransactionsParserImpl implements TransactionParser<List<FruitTransaction>, String> {
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
            fruitTransactions.add(FruitTransaction.valueOf(records[i]));
        }
        return fruitTransactions;
    }
}
