package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.operationstrategy.OperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitRecordsDaoImpl implements FruitRecordsDao {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public void saveAll(List<TransactionDto> fruitRecordsList,
                        OperationStrategy operationStrategy) {
        fruitRecordsList.forEach(t -> FruitStorage.fruitStorage.put(t.getFruit(),
                operationStrategy.get(t.getOperationType()).doOperation(t)));
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return FruitStorage.fruitStorage;
    }

    @Override
    public List<String> getAllAsList() {
        List<String> dataList = getAll().entrySet()
                .stream()
                .map(e -> e.getKey().getFruitName() + COMMA + e.getValue())
                .collect(Collectors.toList());
        dataList.add(0, HEADER);
        return dataList;
    }
}
