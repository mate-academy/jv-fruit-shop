package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int NUMBER_OF_ELEMENTS = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        if (inputReport == null) {
            throw new RuntimeException("The data from the file was not read.");
        }

        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String item : inputReport) {
            String[] arrayFromItem = item.split(",");
            if (arrayFromItem.length > NUMBER_OF_ELEMENTS) {
                throw new RuntimeException("The number of elements in a file line"
                        + " is greater than 3");
            }

            FruitTransaction fruitTransaction = new FruitTransaction();
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .fromCode(arrayFromItem[OPERATION_INDEX]);
            String fruit = arrayFromItem[FRUIT_INDEX];
            int quantity = Integer.parseInt(arrayFromItem[QUANTITY_INDEX]);

            if (fruit.equals("")) {
                throw new RuntimeException("Complete information was not provided when entering "
                        + "data for the BALANCE operation");
            }

            if (quantity < 0) {
                throw new RuntimeException("The quantity of " + fruitTransaction.getFruit()
                        + " for " + fruitTransaction.getOperation()
                        + " operation cannot be negative");
            }
            fruitTransaction.setOperation(operation);
            fruitTransaction.setFruit(fruit);
            fruitTransaction.setQuantity(quantity);
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
