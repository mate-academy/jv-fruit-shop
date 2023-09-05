package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.util.ParserReader;
import java.util.ArrayList;
import java.util.List;

public class ParserReaderImpl implements ParserReader {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String REGEX = ",";

    @Override
    public List<FruitTransaction> parsedToFruitTransaction(List<String> records) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String record : records) {
            String[] transaction = record.split(REGEX);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction
                    .getByCode(transaction[OPERATION_INDEX].trim()));
            fruitTransaction.setFruit(transaction[FRUIT_INDEX].trim());
            fruitTransaction.setQuantity(Integer.parseInt(transaction[QUANTITY_INDEX]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
