package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ParseServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.operations.BalanceOperationHandlerImpl;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.PurchaseOperationHandlerImpl;
import core.basesyntax.service.operations.ReturnOperationHandlerImpl;
import core.basesyntax.service.operations.SupplyOperationHandlerImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.template.FruitTransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationsHandlerMap = new HashMap<>();
        operationsHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandlerImpl(storageDao));
        operationsHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandlerImpl(storageDao));
        operationsHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandlerImpl(storageDao));
        operationsHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandlerImpl(storageDao));


        FileService fileService = new FileServiceImpl();
        ParseService parseService = new ParseServiceImpl();
        ReportService reportService = new ReportServiceImpl(storageDao);

        List<String> dataOperationsFromFile = fileService.readFromFile("src/main/java/inputdata.csv");

        OperationStrategy strategy = new OperationStrategyImpl(operationsHandlerMap);
        dataOperationsFromFile.
                stream()
                .map(parseService::parseLine)
                .forEach(transaction -> strategy.get(transaction.getOperation()).handle(transaction));

        String report = reportService.createReport();
        fileService.writeToFile(report, "storagereport.csv");
    }

}
