package core.basesyntax.service.operationwithdata;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.fruitmodel.Fruit;
import core.basesyntax.fruitstorage.FruitStorage;
import core.basesyntax.validate.ValidationSubtractOperation;
import core.basesyntax.validate.ValidationSubtractOperationValue;
import java.util.Optional;

public class SubtractOperation implements FruitOperationService {
    private ValidationSubtractOperation validationSubtractOperation
            = new ValidationSubtractOperationValue();

    @Override
    public int apply(FruitDto fruitDto) {
        Fruit fruit = new Fruit(fruitDto.getFruitName());
        FruitStorage fruitStorage = new FruitStorage();
        Optional<Integer> currentQuantityFruit =
                Optional.ofNullable(fruitStorage.get(fruit));
        int newBalance = 0;
        if (currentQuantityFruit.isPresent()
                && validationSubtractOperation
                .validateDeleteOperation(currentQuantityFruit.get(), fruitDto.getCountFruit())) {
            newBalance = currentQuantityFruit.get() - fruitDto.getCountFruit();
            fruitStorage.save(fruit, newBalance);
        }
        return newBalance;
    }
}
