package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.operationstrategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public interface FruitRecordsDao {
    void saveAll(List<TransactionDto> fruitRecordsList, OperationStrategy operationStrategy);

    Map<Fruit, Integer> getAll();

    List<String> getAllAsList();
}
