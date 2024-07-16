package core.basesyntax.service.impl;

import core.basesyntax.db.FruitTransaction;
import core.basesyntax.service.DeepCopy;
import java.util.ArrayList;
import java.util.List;

public class DeepCopyImpl implements DeepCopy {
    @Override
    public List<FruitTransaction> getDeepCopy(List<FruitTransaction> list) {
        List<FruitTransaction> copyList = new ArrayList<>(list.size());
        for (FruitTransaction fruit : list) {
            copyList.add(new FruitTransaction(fruit.getType(),
                    fruit.getFruit(), fruit.getQuantity()));
        }
        return copyList;
    }
}
