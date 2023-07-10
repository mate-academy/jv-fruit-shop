package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final String CSV_SEPARATOR = ",";
    private static final int PARAM_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> fileLines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < fileLines.size(); i++) {
            String[] parsedData = fileLines.get(i).split(CSV_SEPARATOR);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getByCode(parsedData[PARAM_INDEX]));
            fruitTransaction.setFruit(parsedData[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(parsedData[QUANTITY_INDEX]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
