package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.LineParserService;
import core.basesyntax.service.OperationService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import java.util.List;
import java.util.Map;

public class OperationServiceImpl implements OperationService {
    @Override
    public void action(Map<FruitTransaction.Operation, OperationHandler> operationHandler,
                       List<String> infoFromFile) {
        LineParserService fruitParse = new LineParserServiceImpl();
        List<FruitTransaction> lineInfo = fruitParse.parse(infoFromFile);
        Strategy strategy = new StrategyImpl(operationHandler);
        lineInfo.forEach(p -> strategy.get(p.getOperation()).handle(p));
    }
}
