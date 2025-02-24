package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataFruitConverterImpl implements DataConverter<FruitTransaction> {
    public static final int OPERATION_POSITION = 0;
    public static final int FRUIT_POSITION = 1;
    public static final int QUANTITY_POSITION = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String[]> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            String operationCode = row[OPERATION_POSITION];
            String fruit = row[FRUIT_POSITION];
            int quantity = Integer.parseInt(row[QUANTITY_POSITION]);
            Operation operation = Operation.fromCode(operationCode);
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(operation);
            transaction.setFruit(fruit);
            transaction.setQuantity(quantity);
            fruitTransactions.add(transaction);
        }
        return fruitTransactions;
    }
}
