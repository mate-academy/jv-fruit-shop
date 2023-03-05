package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CalculateDataForReport {
    public void create(List<FruitTransaction> list);
}
