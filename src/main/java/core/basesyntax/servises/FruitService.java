package core.basesyntax.servises;

import core.basesyntax.models.FruitTransaction;
import java.util.List;

public interface FruitService {
    public void applyTransaction(List<FruitTransaction> list);
}
