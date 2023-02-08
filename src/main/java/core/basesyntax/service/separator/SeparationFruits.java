package core.basesyntax.service.separator;

import core.basesyntax.entity.FruitTransaction;
import java.util.List;

public interface SeparationFruits {
    List<FruitTransaction> separationFruits(List<String> stringListFruits,
                                                         String fruitWithFile, boolean useDataBase);
}
