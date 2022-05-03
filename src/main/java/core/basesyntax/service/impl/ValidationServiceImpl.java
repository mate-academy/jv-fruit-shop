package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ValidationService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class ValidationServiceImpl implements ValidationService {
    private static final String VALIDATION_PATTERN = "[bspr]";
    private final ParserService parserService;
    private final Map<String, OperationHandler> handlerMap;

    public ValidationServiceImpl(ParserService parserService,
                                 Map<String, OperationHandler> handlerMap) {
        this.parserService = parserService;
        this.handlerMap = handlerMap;
    }

    @Override
    public void validate(List<String> list) {
        list.removeIf(line -> !String.valueOf(line.charAt(0)).matches(VALIDATION_PATTERN));
        for (String line : list) {
            FruitTransaction fruitTransaction = parserService.parse(line);
            OperationHandler operationHandler = handlerMap.get(fruitTransaction
                    .getOperation().getOperationType());
            operationHandler.process(new Fruit(fruitTransaction.getFruitName()),
                    fruitTransaction.getQuantity());
        }
    }
}
