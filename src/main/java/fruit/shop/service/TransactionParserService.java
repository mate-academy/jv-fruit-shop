package fruit.shop.service;

import fruit.shop.model.FruitTransaction;
import java.util.List;

public interface TransactionParserService {
    List<FruitTransaction> parse(List<String> transaction);
}
