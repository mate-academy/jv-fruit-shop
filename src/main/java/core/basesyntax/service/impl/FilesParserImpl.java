package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FilesParser;
import java.util.ArrayList;
import java.util.List;

public class FilesParserImpl implements FilesParser {
    private static final String SEPARATOR = ",";
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final int INDEX_TWO = 2;

    @Override
    public List<FruitTransaction> parseFruitTransaction(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] parsedData = data.get(i).split(SEPARATOR);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getByCode(FruitTransaction.Operation.class, parsedData[INDEX_ZERO]));
            fruitTransaction.setFruit(parsedData[INDEX_ONE]);
            fruitTransaction.setQuantity(Integer.parseInt(parsedData[INDEX_TWO]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
