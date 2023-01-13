package solid.model;

import java.util.List;

public interface FruitTransactionParser {
    List<FruitTransaction> toTransaction(String data);
}
