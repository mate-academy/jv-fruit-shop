package core.basesyntax.strategy.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.OperationStategy;
import java.util.List;

public class OperationStategyImpl implements OperationStategy {

    private List<OperationHandler> handlers;

    public OperationStategyImpl(List<OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public List<OperationHandler> get(FruitTransactionDto dto) {
        return handlers.stream()
                       .filter(h -> h.isApplicable(dto))
                       .toList();
    }
}
