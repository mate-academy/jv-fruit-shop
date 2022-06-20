package core.basesyntax.service.impl;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.dao.ShopDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.LineParserService;
import core.basesyntax.service.OperationService;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationServiceImpl implements OperationService {
    @Override
    public void action(List<String> infoFromFile) {
        ShopDao shopDao = new ShopDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandler = new HashMap<>();
        operationHandler.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(shopDao));
        operationHandler.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(shopDao));
        operationHandler.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(shopDao));
        operationHandler.put(FruitTransaction.Operation.RETURN, new ReturnHandler(shopDao));
        LineParserService fruitParse = new LineParserServiceImpl();
        List<FruitTransaction> lineInfo = fruitParse.parse(infoFromFile);
        Strategy strategy = new StrategyImpl(operationHandler);
        lineInfo.forEach(p -> strategy.get(p.getOperation()).handle(p));
    }
}
