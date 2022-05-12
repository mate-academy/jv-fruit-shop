package core.basesyntax.servise;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessDataService {
    String processData(List<FruitTransaction> data);
}
