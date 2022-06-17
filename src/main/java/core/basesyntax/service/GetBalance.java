package core.basesyntax.service;

import core.basesyntax.model.Model;
import java.util.List;

public interface GetBalance {
    void calcBalance(List<Model> fruitsMoving, ActionStrategy mapStrategy);
}
