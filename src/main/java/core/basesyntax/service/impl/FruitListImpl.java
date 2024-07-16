package core.basesyntax.service.impl;

import core.basesyntax.db.FruitTransaction;
import core.basesyntax.service.FruitList;
import java.util.ArrayList;
import java.util.List;

public class FruitListImpl implements FruitList {
    @Override
    public List<FruitTransaction> getFruitList(List<FruitTransaction> list) {
        List<String> listOfFruitsString = list.stream()
                .map(FruitTransaction::getFruit)
                .distinct()
                .toList();
        List<FruitTransaction> listOfFruitsAsObjects = new ArrayList<>();
        for (String fruit : listOfFruitsString) {
            int defaultQuantity = 0;
            listOfFruitsAsObjects.add(new FruitTransaction(fruit, defaultQuantity));
        }
        return listOfFruitsAsObjects;
    }
}
