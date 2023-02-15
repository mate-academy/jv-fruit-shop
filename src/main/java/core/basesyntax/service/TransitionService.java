package core.basesyntax.service;

import core.basesyntax.model.FruitTransition;
import java.util.List;

public interface TransitionService {
    void doTransition(List<FruitTransition> fruitTransitionList);
}
