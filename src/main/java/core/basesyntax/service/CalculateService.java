package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CalculateService {
    public void process(List<FruitTransaction> list);
}
