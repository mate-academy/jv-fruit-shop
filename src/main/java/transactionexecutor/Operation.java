package transactionexecutor;

import fruittransaction.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface Operation {
    Map<String, Integer> startOperation(List<FruitTransaction> products);
}
