package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.ProductTransaction;
import core.basesyntax.model.Setting;
import core.basesyntax.service.ParseServiceImpl;
import core.basesyntax.service.ProcessorServiceImpl;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.WriterServiceImpl;
import core.basesyntax.strategy.ActionStrategy;
import core.basesyntax.strategy.ActionStrategyImpl;
import core.basesyntax.strategy.action.ActionHandler;
import core.basesyntax.strategy.action.BalanceHandler;
import core.basesyntax.strategy.action.PurchaseHandler;
import core.basesyntax.strategy.action.ReturnHandler;
import core.basesyntax.strategy.action.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Map<ProductTransaction.Operation, ActionHandler> actionHandlerMap = new HashMap<>();
        actionHandlerMap.put(ProductTransaction.Operation.BALANCE, new BalanceHandler());
        actionHandlerMap.put(ProductTransaction.Operation.SUPPLY, new SupplyHandler());
        actionHandlerMap.put(ProductTransaction.Operation.PURCHASE, new PurchaseHandler());
        actionHandlerMap.put(ProductTransaction.Operation.RETURN, new ReturnHandler());

        ProductDao productDao = new ProductDaoImpl();
        ActionStrategy actionStrategy = new ActionStrategyImpl(actionHandlerMap);
        ProcessorServiceImpl processor = new ProcessorServiceImpl(actionStrategy, productDao);

        List<String> data = new ReaderServiceImpl().read(Setting.FILE_NAME_INPUT);
        Queue<ProductTransaction> transactions = new ParseServiceImpl().parse(data);
        processor.processing(transactions);
        new WriterServiceImpl().write(Setting.FILE_NAME_OUTPUT, processor.report());
    }
}
