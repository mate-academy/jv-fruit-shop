package core.basesyntax.handlers;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convert(List<String> value);
}
