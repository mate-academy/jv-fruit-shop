package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface FruitShopService {
    void runTransaction(List<Transaction> list);
}
