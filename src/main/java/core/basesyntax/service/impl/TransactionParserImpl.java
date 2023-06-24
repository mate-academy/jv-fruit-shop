package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    public static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parse(List<String> transactionsStrings) {
        List<FruitTransaction> parsedTransactions = new ArrayList<>();
        for (String transactionStrings : transactionsStrings) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] splittedString = transactionStrings.split(SEPARATOR);
            fruitTransaction.setOperation(Operation
                    .getByCode(splittedString[OPERATION_INDEX]));
            fruitTransaction.setFruit(splittedString[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(splittedString[QUANTITY_INDEX]));
            parsedTransactions.add(fruitTransaction);
        }
        return parsedTransactions;
    }
}
