package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import java.util.ArrayList;
import java.util.List;

public class DataParserServiceImpl implements DataParserService {
    private static final String SEPARATOR = ",";
    private static final int TRANSACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> toTransactions(List<String> fromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < fromFile.size(); i++) {
            String[] partsTransaction = fromFile.get(i).split(SEPARATOR);
            String transaction = partsTransaction[TRANSACTION_INDEX];
            String fruit = partsTransaction[FRUIT_INDEX];
            int quantity = Integer.parseInt(partsTransaction[QUANTITY_INDEX]);
            FruitTransaction fruitTransaction =
                    new FruitTransaction(FruitTransaction.Operation.getOperation(transaction),
                            fruit, quantity);
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
