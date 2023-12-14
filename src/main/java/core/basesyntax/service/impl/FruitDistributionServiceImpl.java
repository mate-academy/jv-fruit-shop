package core.basesyntax.service.impl;

import core.basesyntax.service.FruitDistributionService;
import core.basesyntax.service.FruitParser;
import core.basesyntax.strategy.FruitDistributionStrategy;
import java.util.List;

public class FruitDistributionServiceImpl implements FruitDistributionService<String> {
    private static final int HEADER = 1;
    private final FruitDistributionStrategy distributionStrategy;

    public FruitDistributionServiceImpl(FruitDistributionStrategy distributionStrategy) {
        this.distributionStrategy = distributionStrategy;
    }

    @Override
    public void countFruitDistribution(List<String> inputData) {
        FruitParser fruitParser = new FruitParserImpl();
        inputData.stream()
                .skip(HEADER)
                .map(fruitParser::parseString)
                .forEach(t -> distributionStrategy
                        .getActivity(t.getOperation()).updateStorageData(t));
    }
}
