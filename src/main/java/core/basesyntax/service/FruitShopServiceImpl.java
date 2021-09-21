package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<Fruit, Integer> transact(List<TransactionDto> transactionDtoList,
                                        OperationStrategy operationStrategy) {
        Storage storage = new Storage();
        Map<Fruit, Integer> fruitsStorage = storage.getAllData();
        for (TransactionDto transactionDto : transactionDtoList) {
            String type = transactionDto.getType();
            fruitsStorage.put(transactionDto.getFruit(),
                    operationStrategy.getHandler(type).apply(transactionDto, fruitsStorage));
        }
        return fruitsStorage;
    }
}
