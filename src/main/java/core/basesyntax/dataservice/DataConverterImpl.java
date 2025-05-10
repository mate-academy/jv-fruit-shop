package core.basesyntax.dataservice;

import core.basesyntax.transactions.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int NUMBER = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        data.stream()
                .map(array -> array.split(SEPARATOR))
                .forEach(strings -> {
                    FruitTransaction fruitTransaction = new FruitTransaction();
                    fruitTransaction.setFruit(strings[FRUIT_TYPE]);
                    fruitTransaction.setQuantity(Integer.parseInt(strings[NUMBER]));
                    fruitTransaction.setOperation(FruitTransaction.Operation
                            .coverToOperation(strings[OPERATION]));
                    fruitTransactionList.add(fruitTransaction);
                });
        return fruitTransactionList;
    }
}
