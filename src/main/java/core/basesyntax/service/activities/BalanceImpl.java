package core.basesyntax.service.activities;

import core.basesyntax.model.Fruit;

import java.util.HashMap;
import java.util.List;

public class BalanceImpl implements Balance{
    private List<Fruit> balance = (List<Fruit>) new HashMap<Fruit, Integer>();
    @Override
    public List<Fruit> beginBalance() {

    }
}
