package fruit.shop.service;

import fruit.shop.model.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> getTransactions(List<String> data);
}
