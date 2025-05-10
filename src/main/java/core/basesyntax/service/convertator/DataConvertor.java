package core.basesyntax.service.convertator;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConvertor {
    List<FruitTransaction> convertData(String data);
}
