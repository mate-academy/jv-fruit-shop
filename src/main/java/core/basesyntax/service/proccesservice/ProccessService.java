package core.basesyntax.service.proccesservice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProccessService {
    void proccessing(List<FruitTransaction> fruitTransactionsList);
}
