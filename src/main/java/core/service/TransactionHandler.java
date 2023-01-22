package core.service;

import core.model.FruitTransaction;
import java.util.List;

public interface TransactionHandler {
    void handle(List<FruitTransaction> parseList);
}
