package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Transaction;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private static final String SEPARATOR = ",";
    private static final int INDEX_BY_TRANSACTION = 0;
    private static final int INDEX_BY_FRUIT = 1;
    private static final int INDEX_BY_AMOUNT = 2;

    public List<FruitTransaction> convertText(List<String> strings) {
        List<FruitTransaction> dataFruitTransaction = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            String[] data = strings.get(i).split(SEPARATOR);
            dataFruitTransaction
                    .add(new FruitTransaction(Transaction.getTransactionByCode(data[0]),
                            data[1],Integer.parseInt(data[2])));
        }
        return dataFruitTransaction;
    }
}
