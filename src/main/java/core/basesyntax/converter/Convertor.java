package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Convertor {
    List<FruitTransaction> convertToTransaction(List<String> report);
}
