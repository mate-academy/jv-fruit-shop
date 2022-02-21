package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ManipulationService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.Strategy;
import java.util.List;
import java.util.stream.IntStream;

public class ManipulationServiceImpl implements ManipulationService {
    private final Strategy strategy;

    public ManipulationServiceImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void manipulation(List<Transaction> data) {
        IntStream.range(0, data.size())
                .forEach(i -> {
                    OperationHandler operationHandler = strategy
                            .getActivity(data.get(i).getOperationType());
                    operationHandler.applyOperation(data.get(i));
                });
    }
}
