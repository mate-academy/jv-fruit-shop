package core.basesyntax.service.impl;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.models.Operation;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParser implements Parser<FruitTransaction> {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int FRUIT_AMOUNT = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        List<FruitTransaction> parsedData = new ArrayList<>();

        for (var element : data) {
            String[] separatedData = element.split(SEPARATOR);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(Operation.fromCode(separatedData[OPERATION_TYPE]));
            fruitTransaction.setFruit(separatedData[FRUIT_TYPE]);

            int fruitAmount = Integer.parseInt(separatedData[FRUIT_AMOUNT]);
            if (fruitAmount < 0) {
                throw new RuntimeException("Data in file can't be less then 0.");
            }

            fruitTransaction.setQuantity(fruitAmount);
            parsedData.add(fruitTransaction);
        }

        return parsedData;
    }
}
