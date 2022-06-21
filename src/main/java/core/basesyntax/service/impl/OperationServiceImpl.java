package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.LineParserService;
import core.basesyntax.service.OperationMap;
import core.basesyntax.service.OperationService;
import java.util.List;

public class OperationServiceImpl implements OperationService {
    private final OperationMap operationMap;

    public OperationServiceImpl(OperationMap operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public void action(List<String> infoFromFile) {
        LineParserService fruitParse = new LineParserServiceImpl();
        List<FruitTransaction> lineInfo = fruitParse.parse(infoFromFile);
        lineInfo.forEach(p -> operationMap.get(p.getOperation()).handle(p));
    }
}
