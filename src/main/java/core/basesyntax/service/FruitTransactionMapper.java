package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionMapper {
    List<FruitTransaction> map(List<String> data);
}
