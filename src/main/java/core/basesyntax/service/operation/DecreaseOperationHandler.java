package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitRecordDto;
import java.util.Map;
import java.util.Optional;

public class DecreaseOperationHandler implements OperationHandler {

    @Override
    public int getAmount(FruitRecordDto fruitRecordDto, Map<String, Integer> fruitsStorage) {
        Optional<Integer> amount
                = Optional.ofNullable(FruitStorage.fruitsDataBase.get(fruitRecordDto.getFruit()));
        int newAmount = amount.orElseThrow(() -> new RuntimeException("Not enough fruit."))
                - fruitRecordDto.getAmount();
        if (newAmount < 0) {
            throw new RuntimeException("Not enough fruit to sell.");
        }
        return newAmount;
    }

}
