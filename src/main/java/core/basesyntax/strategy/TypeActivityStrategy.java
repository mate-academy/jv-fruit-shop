package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;

import java.util.List;

public interface TypeActivityStrategy {
   void setNewAmount(Integer amount, FruitTransaction fruitTransaction);
}
