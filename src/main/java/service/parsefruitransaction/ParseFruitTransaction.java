package service.parsefruitransaction;

import java.util.List;
import model.FruitTransaction;

public interface ParseFruitTransaction {
    List<FruitTransaction> getParseFruitTransaction(List<String> rowFruitTransaction);
}
