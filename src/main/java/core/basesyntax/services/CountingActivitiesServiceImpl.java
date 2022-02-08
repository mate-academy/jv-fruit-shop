package core.basesyntax.services;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.storage.FruitStorage;
import java.util.List;
import java.util.Map;

public class CountingActivitiesServiceImpl implements CountingActivitiesService {
    private final ValidatorService validatorService = new ValidatorServiceImpl();

    @Override
    public Map<Fruit, Integer> countingActivities(List<Operation> operations,
                                                   FruitStrategy fruitStrategy) {
        Map<Fruit, Integer> fruitStorage = FruitStorage.getFruitStorage();
        for (Operation recording : operations) {
            String type = recording.getType();
            fruitStorage.put(recording.getFruit(),
                        fruitStrategy.getHandler(type).newQuantity(recording, fruitStorage));
            validatorService.correctAmountValidator(fruitStorage);
        }
        return fruitStorage;
    }
}
