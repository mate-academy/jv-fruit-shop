package fruitshop.model;

import java.util.List;

public interface SaveData {
    List<FruitTransaction> transactionData(List<String> readFile);
}
