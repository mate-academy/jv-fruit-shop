package strategy;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface Residue {
    Map<String, Integer> getResidue(List<FruitTransaction> fruitsTransactionData);
}
