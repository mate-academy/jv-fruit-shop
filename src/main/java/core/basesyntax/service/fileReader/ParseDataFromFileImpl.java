package core.basesyntax.service.fileReader;

import core.basesyntax.model.FruitTransaction;

import java.util.ArrayList;
import java.util.List;

public class ParseDataFromFileImpl implements ParseDataFromFile {
    static final int OPERATION_TYPE = 0;
    static final int FRUIT_TYPE = 1;
    static final int FRUITS_QUANTITY = 2;
    static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parsedFruitsTransactions(List<String> fruitsTransactions) {
        List<FruitTransaction> parsedData = new ArrayList<>();
        for (String transaction : fruitsTransactions) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] splitTransaction = transaction.split(SEPARATOR);
            fruitTransaction.setOperation(new FindTransactionTypeImpl()
                    .operationType(splitTransaction[OPERATION_TYPE]));
            fruitTransaction.setFruit(splitTransaction[FRUIT_TYPE]);
            fruitTransaction.setQuantity(Integer.parseInt(splitTransaction[FRUITS_QUANTITY]));
            parsedData.add(fruitTransaction);
        }
        return parsedData;
    }
}
