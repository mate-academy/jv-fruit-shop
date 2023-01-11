package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;
import java.util.Set;

public interface FruitService {
     void calculateFruit(List<FruitTransaction> fruits);
}
