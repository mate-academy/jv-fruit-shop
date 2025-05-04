package fruitshop.service;

import fruitshop.model.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransactions(List<String> lines);
}

