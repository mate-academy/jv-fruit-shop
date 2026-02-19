package core.basesyntax.data;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransactionsListFromLines(List<String> lines) {
        List<FruitTransaction> transactionList = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] lineParts = lines.get(i).split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setFruit(lineParts[FRUIT]);
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .fromCode(lineParts[OPERATION]));
            fruitTransaction.setQuantity(Integer.parseInt(lineParts[QUANTITY]));
            transactionList.add(fruitTransaction);
        }
        return transactionList;
    }
}
