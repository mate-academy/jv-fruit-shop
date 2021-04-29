package core.basesyntax.service.operationwithdata;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.fruitoperationstrategy.FruitStrategy;
import core.basesyntax.fruitstorage.FruitStorage;
import java.util.List;

public class FruitOperationHandler implements OperationHandler {
    private FruitStrategy fruitStrategy;

    public FruitOperationHandler(FruitStrategy fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public void operationProcessing(List<FruitDto> fruitDtos) {
        for (FruitDto fruit : fruitDtos) {
            FruitOperationService fruitOperationService = fruitStrategy.get(fruit.getOperation());
            int quantity = fruitOperationService.apply(fruit);
            FruitStorage.fruitStorage.put(fruit.getFruitName(), quantity);
        }
    }
}
