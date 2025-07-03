package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataConvertorImpl implements DataConvertor {

    @Override
    public List<FruitTransaction> dataConvert(List<String> allLines) {
        if (allLines.size() < 2 || allLines.isEmpty()) {
            throw new RuntimeException("Empty lines");
        }
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < allLines.size(); i++) {
            String[] parts = allLines.get(i).split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid line: " + allLines.get(i));
            }
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(parts[0]));
            fruitTransaction.setFruit(parts[1]);
            fruitTransaction.setQuantity(Integer.parseInt(parts[2]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
