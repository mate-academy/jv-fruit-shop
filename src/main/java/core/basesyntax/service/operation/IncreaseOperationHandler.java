package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitRecordDto;
import java.util.Map;
import java.util.Optional;

public class IncreaseOperationHandler implements OperationHandler {
    private static final Integer INITIAL_AMOUNT = 0;

    @Override
    public int getAmount(FruitRecordDto fruitRecordDto, Map<String, Integer> fruitsStorage) {
        Optional<Integer> amount
                = Optional.ofNullable(FruitStorage.fruitsDataBase.get(fruitRecordDto.getFruit()));
        return amount.orElse(INITIAL_AMOUNT) + fruitRecordDto.getAmount();
    }
}
