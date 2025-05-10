package fruitshop.service;

import fruitshop.model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> inputReport);
}
