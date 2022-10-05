package core.basesyntax.sevrice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionParser {
    List<FruitTransaction> parse(List<String> dataFromFile);
}
