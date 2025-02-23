package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataFruitConverterImpl implements DataConverter<FruitTransaction> {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String[]> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            String operation = row[0];
            String fruit = row[1];
            int quantity = Integer.parseInt(row[2]);
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(operation);
            transaction.setFruit(fruit);
            transaction.setQuantity(quantity);
            fruitTransactions.add(transaction);
        }
        return fruitTransactions;
    }
}
