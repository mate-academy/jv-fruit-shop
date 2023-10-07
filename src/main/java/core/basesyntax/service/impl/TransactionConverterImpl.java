package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionConverter;
import java.util.ArrayList;
import java.util.List;

public class TransactionConverterImpl implements TransactionConverter {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(String data) {
        String[] dataFruitTransactions = data.split(System.lineSeparator());
        List<FruitTransaction> fruits = new ArrayList<>();
        for (int i = 1; i < dataFruitTransactions.length; i++) {
            String[] transactionLine = dataFruitTransactions[i].split(",");
            fruits.add(createFruitTransaction(transactionLine[TYPE_INDEX].charAt(TYPE_INDEX),
                                   transactionLine[FRUIT_NAME_INDEX],
                                   Integer.parseInt(transactionLine[AMOUNT_INDEX])));
        }
        return fruits;
    }

    private FruitTransaction createFruitTransaction(char type, String name, int amount) {
        return new FruitTransaction(type, name, amount);
    }
}
