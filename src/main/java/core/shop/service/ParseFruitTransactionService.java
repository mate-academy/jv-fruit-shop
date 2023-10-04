package core.shop.service;

import core.shop.model.FruitTransaction;
import java.util.List;

public interface ParseFruitTransactionService {
    List<FruitTransaction> getFruitOperations(List<String> list);
}
