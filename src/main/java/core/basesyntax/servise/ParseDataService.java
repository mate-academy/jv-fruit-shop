package core.basesyntax.servise;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParseDataService {
    List<FruitTransaction> parse(List<String> dataFromFile);
}
