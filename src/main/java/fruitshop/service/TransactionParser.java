package fruitshop.service;

import fruitshop.model.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parseReport(List<String> stringList);
}
