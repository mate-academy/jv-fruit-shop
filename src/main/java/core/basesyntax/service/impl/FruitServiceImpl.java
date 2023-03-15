package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;

import java.util.ArrayList;
import java.util.List;

public class FruitServiceImpl implements FruitService {

    @Override
    public List<FruitTransaction> addNewFruit(List<String[]> convertedData) {
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        for (String[] s : convertedData) {
            int quantity = Integer.parseInt(s[2]);
            String fruit = s[1];
            String operation = s[0];
            fruitTransactionsList.add(new FruitTransaction(quantity,
                    FruitTransaction.Operation.getOperation(operation), fruit));
        }
        return fruitTransactionsList;
    }
}
