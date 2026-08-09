package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface IDataConverter {
    List<FruitTransaction> convertData(List<String> data);
}
