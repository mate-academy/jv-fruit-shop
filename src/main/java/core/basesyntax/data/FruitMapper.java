package core.basesyntax.data;

import core.basesyntax.data.FruitTransaction.Operation;
import java.util.ArrayList;
import java.util.List;

public class FruitMapper {
    private static final String REGEX_COMMA = ",";

    public List<FruitTransaction> mapData(List<String> lines) {
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] data = lines.get(i).split(REGEX_COMMA);
            Operation operation = Operation.valueOf(data[0]);
            String fruitType = data[1];
            int quantity = Integer.parseInt(data[2]);
            FruitTransaction fruitTransaction =
                    new FruitTransaction(operation, fruitType, quantity);
            fruitTransactionsList.add(fruitTransaction);
        }
        return fruitTransactionsList;
    }
}
