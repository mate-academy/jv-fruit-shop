package core.basesyntax.service;

import core.basesyntax.modelfruit.ModelFruit;

import java.util.List;

public interface Balance {
    void calculateBalance(List<ModelFruit> fruitsMoving, ActionStrategy mapStrategy);
}
