package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.file.work.CsvFileReaderService;
import core.basesyntax.service.file.work.CsvFileReaderServiceImpl;
import core.basesyntax.service.file.work.CsvFileWriterService;
import core.basesyntax.service.file.work.CsvFileWriterServiceImpl;
import core.basesyntax.service.operations.FruitTransactionCreationService;
import core.basesyntax.service.operations.FruitTransactionCreationServiceImpl;
import core.basesyntax.service.operations.FruitTransactionReportMaker;
import core.basesyntax.service.operations.FruitTransactionReportMakerImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
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
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);
        FruitTransactionReportMaker reportMaker =
                new FruitTransactionReportMakerImpl(operationStrategy);
        CsvFileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        CsvFileWriterService fileWriterService = new CsvFileWriterServiceImpl();
        FruitDao dao = new FruitDaoImpl();
        FruitTransactionCreationService transactionService
                = new FruitTransactionCreationServiceImpl(dao);
        List<String[]> fileData = fileReaderService
                .readFile("src/main/resources/readFromFile.csv");
        transactionService.createTransactions(fileData);
        List<FruitTransaction> report = reportMaker.makeReport(dao);
        fileWriterService.writeToFile("src/main/resources/storeToFile.csv", report);
    }
}
