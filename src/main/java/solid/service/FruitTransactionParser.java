package solid.service;

import java.util.List;
import solid.model.FruitTransaction;

public interface FruitTransactionParser {
    List<FruitTransaction> toTransaction(String data);
}
