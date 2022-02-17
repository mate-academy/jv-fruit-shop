package fruitshop.model;

import java.util.List;

public interface TransactionService {
    List<FruitTransaction> transactionData(List<String> readFile);
}
