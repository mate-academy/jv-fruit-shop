package core.basesyntax.service.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConverterData {
    List<FruitTransaction> getFruitsOperation(List<String> list);
}
