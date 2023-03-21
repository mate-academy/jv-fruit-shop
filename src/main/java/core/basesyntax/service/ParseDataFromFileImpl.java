package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.interfaces.FindTransactionType;
import core.basesyntax.service.interfaces.ParseDataFromFile;

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
            fruitTransaction.setOperation(new FindTransactionTypeImpl().operationType(splitTransaction[0]));
            fruitTransaction.setFruit(splitTransaction[1]);
            fruitTransaction.setQuantity(Integer.parseInt(splitTransaction[2]));
            parsedData.add(fruitTransaction);
        }
        return parsedData;
    }
}
