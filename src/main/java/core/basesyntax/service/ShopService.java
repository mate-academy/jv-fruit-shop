package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.ResultData;
import java.util.List;

public interface ShopService {
    List<ResultData> process(List<FruitTransaction> list);
}
