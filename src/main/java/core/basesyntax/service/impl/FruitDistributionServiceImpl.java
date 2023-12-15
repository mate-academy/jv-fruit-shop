package core.basesyntax.service.impl;

import core.basesyntax.service.FruitDistributionService;
import core.basesyntax.service.FruitParser;
import core.basesyntax.strategy.FruitDistributionStrategy;
import java.util.List;

public class FruitDistributionServiceImpl implements FruitDistributionService {
    private static final int HEADER = 1;
    private final FruitDistributionStrategy distributionStrategy;
    private final FruitParser fruitParser;

    public FruitDistributionServiceImpl(FruitDistributionStrategy distributionStrategy) {
        this.distributionStrategy = distributionStrategy;
        this.fruitParser = new FruitParserImpl();
    }

    @Override
    public void countFruitDistribution(List<String> inputData) {
        inputData.stream()
                .skip(HEADER)
                .map(fruitParser::parseString)
                .forEach(t -> distributionStrategy
                        .getActivity(t.getOperation()).updateStorageData(t));
    }
}
