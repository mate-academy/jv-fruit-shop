package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface FruitShopService {
    void doTransaction(List<Transaction> list);
}
