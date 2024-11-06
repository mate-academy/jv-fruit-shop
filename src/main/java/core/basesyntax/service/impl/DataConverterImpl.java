package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int NUMBER_OF_ELEMENTS = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String item: inputReport) {
            String[] arrayFromItem = item.replaceAll(" ", "").split(",");
            if (arrayFromItem.length > NUMBER_OF_ELEMENTS) {
                throw new RuntimeException("The number of elements in a file line"
                        + " is greater than 3");
            }
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(arrayFromItem[0]));
            fruitTransaction.setFruit(arrayFromItem[1]);
            if (Integer.parseInt(arrayFromItem[2]) < 0) {
                throw new RuntimeException("The quantity of fruits cannot be negative.");
            }
            fruitTransaction.setQuantity(Integer.parseInt(arrayFromItem[2]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
