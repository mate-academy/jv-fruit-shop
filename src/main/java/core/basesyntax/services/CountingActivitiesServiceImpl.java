package core.basesyntax.services;

import core.basesyntax.exception.ValidationException;
import core.basesyntax.model.Operation;
import core.basesyntax.services.handlers.DecreaseFruitHandler;
import core.basesyntax.services.handlers.FruitHandler;
import core.basesyntax.services.handlers.IncreaseFruitHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingActivitiesServiceImpl implements CountingActivitiesService {
    private final ValidatorService validatorService = new ValidatorServiceImpl();

    @Override
    public Map<String, Integer> countingActivities(List<Operation> operations,
                                                   Map<String, FruitHandler> fruitStrategy) {
        Map<String, Integer> fruitStorage = new HashMap<>();
        fruitStrategy.put(Operation.TypeOperation.RETURN.getType(),
                new IncreaseFruitHandler());
        fruitStrategy.put(Operation.TypeOperation.SUPPLY.getType(),
                new IncreaseFruitHandler());
        fruitStrategy.put(Operation.TypeOperation.PURCHASE.getType(),
                new DecreaseFruitHandler());
        for (Operation recording : operations) {
            String type = recording.getType();
            if (type.equals(Operation.TypeOperation.BALANCE.getType())) {
                fruitStorage.put(recording.getFruit(), recording.getQuantity());
            } else if (fruitStrategy.containsKey(type)) {
                fruitStorage.put(recording.getFruit(),
                        fruitStrategy.get(type).newQuantity(recording,fruitStorage));
            } else {
                throw new ValidationException("Incorrect operation");
            }
        }
        validatorService.correctAmountValidator(fruitStorage);
        return fruitStorage;
    }
}
