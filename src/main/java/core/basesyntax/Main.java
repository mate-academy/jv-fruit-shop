package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.DataHandlerService;
import core.basesyntax.service.processing.BalanceProcessing;
import core.basesyntax.service.processing.OperationProcessing;
import core.basesyntax.service.processing.PurchaseProcessing;
import core.basesyntax.service.processing.ReturnProcessing;
import core.basesyntax.service.processing.SupplyProcessing;
import core.basesyntax.service.transaction.BalanceHandler;
import core.basesyntax.service.transaction.PurchaseHandler;
import core.basesyntax.service.transaction.ReturnHandler;
import core.basesyntax.service.transaction.SupplyHandler;
import core.basesyntax.service.transaction.TransactionHandler;
import core.basesyntax.serviceimpl.CsvFileReaderServiceImpl;
import core.basesyntax.serviceimpl.CsvFileWriterImpl;
import core.basesyntax.serviceimpl.DataHandlerServiceImpl;
import core.basesyntax.strategy.OperationProcessingStrategy;
import core.basesyntax.strategy.OperationProcessingStrategyImpl;
import core.basesyntax.strategy.TransactionsStrategy;
import core.basesyntax.strategy.TransactionsStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, TransactionHandler> stringTransactionHandlerMap = new HashMap<>();
        stringTransactionHandlerMap.put("b", new BalanceHandler());
        stringTransactionHandlerMap.put("p", new PurchaseHandler());
        stringTransactionHandlerMap.put("r", new ReturnHandler());
        stringTransactionHandlerMap.put("s", new SupplyHandler());
        FruitsDao fruitsDao = new FruitsDaoImpl();

        Map<FruitTransaction.Operation, OperationProcessing> operationProcessingMap =
                new HashMap<>();
        operationProcessingMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceProcessing(fruitsDao));
        operationProcessingMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseProcessing(fruitsDao));
        operationProcessingMap.put(FruitTransaction.Operation.RETURN,
                new ReturnProcessing(fruitsDao));
        operationProcessingMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyProcessing(fruitsDao));

        TransactionsStrategy transactionsStrategy =
                new TransactionsStrategyImpl(stringTransactionHandlerMap);
        CsvFileReaderService fileReaderService =
                new CsvFileReaderServiceImpl();
        OperationProcessingStrategy operationProcessingStrategy =
                new OperationProcessingStrategyImpl(operationProcessingMap); //
        DataHandlerService dataHandlerService = new DataHandlerServiceImpl(fileReaderService,
                operationProcessingStrategy, fruitsDao, transactionsStrategy);
        CsvFileWriter fileWriter = new CsvFileWriterImpl(fruitsDao);

        dataHandlerService.handleData();
        System.out.println(fruitsDao.checkStorage());

        fileWriter.write();
    }
}
