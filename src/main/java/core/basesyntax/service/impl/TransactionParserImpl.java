package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private List<FruitTransaction> fruitTransactionList;
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    private FruitTransaction parseLine(String str) {
        String[] transactionDetails = str.split(",");
        return new FruitTransaction(
                Operation.getType(transactionDetails[OPERATION_TYPE_INDEX ]),
                new Fruit(transactionDetails[FRUIT_INDEX]),
                Integer.parseInt(transactionDetails[QUANTITY_INDEX]));
    }

    @Override
    public List<FruitTransaction> parseTransactions(List<String> csvRowList) {
        fruitTransactionList = new ArrayList<>();

        csvRowList.remove(0);

        for (String row : csvRowList) {
            FruitTransaction fruitTransaction = parseLine(row);
            fruitTransactionList.add(fruitTransaction);
        }

        return fruitTransactionList;
    }
}
