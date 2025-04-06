package core.basesyntax.converter;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface DataConverter {
    public List<FruitTransaction> convertToTransaction(List<String> lines);
}
