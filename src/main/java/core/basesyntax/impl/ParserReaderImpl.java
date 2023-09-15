package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.util.ParserReader;
import java.util.ArrayList;
import java.util.List;

public class ParserReaderImpl implements ParserReader {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";
    private static final int TITLE_INDEX = 0;

    @Override
    public List<FruitTransaction> parsedToFruitTransaction(List<String> records) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        if (records.isEmpty()) {
            return fruitTransactions;
        }
        records.remove(TITLE_INDEX);
        for (String record : records) {
            String[] transaction = record.split(SEPARATOR);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction
                    .getByCode(transaction[OPERATION_INDEX].trim()));
            fruitTransaction.setFruit(transaction[FRUIT_INDEX].trim());
            try {
                fruitTransaction.setQuantity(Integer.parseInt(transaction[QUANTITY_INDEX]));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Wrong transaction: " + record);
            }
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
