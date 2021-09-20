package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.operationstrategy.OperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void saveAll(List<TransactionDto> fruitRecordsList,
                        OperationStrategy operationStrategy) {
        fruitRecordsList.forEach(r -> FruitStorage.fruitStorage.put(r.getFruit(),
                operationStrategy.get(r.getOperationType()).doOperation(r)));
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return FruitStorage.fruitStorage;
    }

    @Override
    public List<String> getAllAsList() {
        String header = "fruit,quantity";
        List<String> dataList = getAll().entrySet()
                .stream()
                .map(e -> e.getKey().getFruitName() + "," + e.getValue())
                .collect(Collectors.toList());
        dataList.add(0, header);
        return dataList;
    }
}
