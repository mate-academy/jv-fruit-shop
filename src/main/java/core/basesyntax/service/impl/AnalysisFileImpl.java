package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.AnalysisFile;
import core.basesyntax.strategy.OperationAnalysis;
import core.basesyntax.strategy.Strategy;
import java.util.List;

public class AnalysisFileImpl implements AnalysisFile {
    private final Strategy strategy;

    public AnalysisFileImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> data) {
        data.stream()
                .forEach(c -> {
                    OperationAnalysis service =
                            strategy.get(c.getOperation());
                    service.processing(c);
                });
    }
}
