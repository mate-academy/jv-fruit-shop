package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface InputDataService {
    List<FruitTransaction> convertDataToObj(List<String> data);
}
