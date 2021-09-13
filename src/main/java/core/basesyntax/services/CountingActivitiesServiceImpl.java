package core.basesyntax.services;

import core.basesyntax.model.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingActivitiesServiceImpl implements CountingActivitiesService {
    private final ValidatorService validatorService = new ValidatorServiceImpl();

    @Override
    public Map<String, Integer> countingActivities(List<Operation> operations,
                                                   FruitStrategy fruitStrategy) {
        Map<String, Integer> fruitStorage = new HashMap<>();
        for (Operation recording : operations) {
            String type = recording.getType();
            if (!fruitStorage.containsKey(recording.getFruit())) {
                fruitStorage.put(recording.getFruit(),recording.getQuantity());
            } else {
                fruitStorage.put(recording.getFruit(),
                        fruitStrategy.getHandler(type).newQuantity(recording, fruitStorage));
                validatorService.correctAmountValidator(fruitStorage);
            }
        }
        return fruitStorage;
    }
}
