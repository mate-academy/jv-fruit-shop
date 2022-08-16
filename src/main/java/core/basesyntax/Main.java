package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.FruitTransactionsProcessor;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.FruitTransactionsProcessorImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operations.BalanceOperation;
import core.basesyntax.strategy.operations.OperationHandler;
import core.basesyntax.strategy.operations.PurchaseOperation;
import core.basesyntax.strategy.operations.ReturnOperation;
import core.basesyntax.strategy.operations.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FruitsDao fruitsDao = new FruitsDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap
                .put(FruitTransaction.Operation.BALANCE, new BalanceOperation(fruitsDao));
        operationHandlerMap
                .put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(fruitsDao));
        operationHandlerMap
                .put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation(fruitsDao));
        operationHandlerMap
                .put(FruitTransaction.Operation.RETURN, new ReturnOperation(fruitsDao));

        ReaderService readerServiceCsv = new ReaderServiceImpl();
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitTransactionsProcessor fruitTransactionsProcessor
                = new FruitTransactionsProcessorImpl(operationStrategy);
        ReportCreator reportCreator = new ReportCreatorImpl("fruit,quantity", fruitsDao);
        FileWriter fileWriter = new FileWriterImpl();

        List<String> fruitTransactions = readerServiceCsv.read("src/main/resources/input.csv");
        List<FruitTransaction> transactions = fruitTransactionService.get(fruitTransactions);
        fruitTransactionsProcessor.process(transactions);
    }
}
