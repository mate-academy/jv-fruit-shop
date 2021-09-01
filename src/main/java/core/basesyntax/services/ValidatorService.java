package core.basesyntax.services;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface ValidatorService {
    void inputDataValidator(List<String> inputData);

    void positiveQuantityValidator(List<String> inputData);

    void correctAmountValidator(Map<Fruit, Integer> countingActivities);
}
