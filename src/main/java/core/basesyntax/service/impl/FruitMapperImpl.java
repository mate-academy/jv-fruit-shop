package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitMapper;
import java.util.ArrayList;
import java.util.List;

public class FruitMapperImpl implements FruitMapper {

    @Override
    public List<FruitTransaction> mapData(List<String> list) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        list.remove(0);
        for (String item : list) {
            String[] data = item.split(",");
            String operation = data[0];
            String fruitType = data[1];
            int quantity = Integer.parseInt(data[2]);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(Operation.getOperationValue(operation));
            fruitTransaction.setFruit(fruitType);
            fruitTransaction.setQuantity(quantity);
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
