package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface FruitStoreService {
    List<Fruit> changeBalance(List<TransactionDto> transactions);
}
