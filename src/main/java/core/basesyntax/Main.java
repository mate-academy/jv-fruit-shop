package core.basesyntax;

import dao.FruitStoreDao;
import dao.FruitStoreDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.StoreOperation;
import service.FileService;
import service.ReportService;
import service.TransactionParser;
import service.impl.FileServiceImpl;
import service.impl.ReportServiceImpl;
import strategy.StoreOperationStrategy;
import strategy.StoreOperationStrategyImpl;
import strategy.handler.BalanceOperationHandler;
import strategy.handler.OperationHandler;
import strategy.handler.PurchaseOperationHandler;
import strategy.handler.ReturnOperationHandler;
import strategy.handler.SupplyOperationHandler;

public class Main {
    public static void main(String[] args) {
        // Reading data from file to List
        final String storeFilePath = "src/main/resources/transactions.csv";
        FileService fileReaderService = new FileServiceImpl();
        List<String> fileData = fileReaderService.readDataFromFile(storeFilePath);
        TransactionParser parser = new TransactionParser();
        final List<FruitTransaction> transactions = parser.parse(fileData);

        // Creating of operation handler Map
        Map<StoreOperation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(StoreOperation.BALANCE, new BalanceOperationHandler());
        handlerMap.put(StoreOperation.SUPPLY, new SupplyOperationHandler());
        handlerMap.put(StoreOperation.PURCHASE, new PurchaseOperationHandler());
        handlerMap.put(StoreOperation.RETURN, new ReturnOperationHandler());

        // Creating an object of StoreOperation Strategy
        StoreOperationStrategy operationStrategy = new StoreOperationStrategyImpl(handlerMap);

        // Processing of data and adding to Storage
        FruitStoreDao fruitStoreDao = new FruitStoreDaoImpl();
        fruitStoreDao.addDataToStorage(transactions, operationStrategy);

        // Creating report list
        ReportService reportService = new ReportServiceImpl();
        String fruitReport = reportService.createReport();

        // Writing report data to csv file
        final String reportFilePath = "src/main/resources/report.csv";
        FileService fileWriterService = new FileServiceImpl();
        fileWriterService.writeDataToFile(reportFilePath, fruitReport);
    }
}
