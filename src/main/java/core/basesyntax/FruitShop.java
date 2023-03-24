package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.TransactionHandlerImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.service.impl.transactions.BalanceHandlerImpl;
import core.basesyntax.service.impl.transactions.PurchaseHandlerImpl;
import core.basesyntax.service.impl.transactions.ReturnHandlerImpl;
import core.basesyntax.service.impl.transactions.SupplyHandlerImpl;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.TransactionStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerServiceMap = new HashMap<>();
        operationHandlerServiceMap.put(FruitTransaction.Operation.BALANCE.getValue(),
                new BalanceHandlerImpl());
        operationHandlerServiceMap.put(FruitTransaction.Operation.PURCHASE.getValue(),
                new PurchaseHandlerImpl());
        operationHandlerServiceMap.put(FruitTransaction.Operation.SUPPLY.getValue(),
                new SupplyHandlerImpl());
        operationHandlerServiceMap.put(FruitTransaction.Operation.RETURN.getValue(),
                new ReturnHandlerImpl());

        TransactionStrategy transactionStrategy =
                new TransactionStrategyImpl(operationHandlerServiceMap);
        TransactionHandler transactionHandler =
                new TransactionHandlerImpl(new StorageDaoImpl(), transactionStrategy);

        ReaderService readerService = new ReaderServiceImpl();
        List<String> list = readerService.readFromFile();
        if (list.size() == 0) {
            throw new RuntimeException("The document is empty");
        }
        List<String> report = transactionHandler.getReport(list);
        new WriteServiceImpl().writeIntoFile(report);
    }
}
