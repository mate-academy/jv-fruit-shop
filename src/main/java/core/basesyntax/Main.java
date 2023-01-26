package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitTransactionCreationService;
import core.basesyntax.service.FruitTransactionOperationsCalculator;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionCreationServiceImpl;
import core.basesyntax.service.impl.FruitTransactionOperationsCalculatorImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import core.basesyntax.strategy.BalanceOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);
        FruitTransactionOperationsCalculator operationsCalculator =
                new FruitTransactionOperationsCalculatorImpl(operationStrategy);
        CsvFileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        CsvFileWriterService fileWriterService = new CsvFileWriterServiceImpl();
        FruitDao dao = new FruitDaoImpl();
        FruitTransactionCreationService transactionService
                = new FruitTransactionCreationServiceImpl(dao);
        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
        List<String[]> fileData = fileReaderService
                .readFile("src/main/resources/readFromFile.csv");
        transactionService.createTransactions(fileData);
        List<FruitTransaction> updatedBalance = operationsCalculator.process(dao);
        String report = reportGeneratorService.generate(updatedBalance);
        fileWriterService.writeToFile("src/main/resources/storeToFile.csv", report);
    }
}
