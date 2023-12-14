package core.basesyntax.service;

import java.util.List;

public interface FruitDistributionService<T> {
    void countFruitDistribution(List<T> inputData);
}
