package core.basesyntax;

import dao.FruitStoreDao;
import dao.FruitStoreDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.StoreOperation;
import service.CreatingFileService;
import service.FileReaderService;
import service.FileWriterService;
import service.ReportService;
import service.impl.CreatingFileServiceImpl;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
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

        // Creating new database file
        String storeFilePath = "src/main/resources/friutshopdatabase.csv";
        CreatingFileService creatingFileStore = new CreatingFileServiceImpl();
        creatingFileStore.createFile(storeFilePath);

        // Writing data to file
        String data = "type,fruit,quantity\n"
                + "b,banana,20\n"
                + "b,apple,100\n"
                + "s,banana,100\n"
                + "p,banana,13\n"
                + "r,apple,10\n"
                + "p,apple,20\n"
                + "p,banana,5\n"
                + "s,banana,50";
        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.writeDataToFile(storeFilePath, data);

        // Reading data from file and adding to Storage
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> fileReader = fileReaderService.readDataFromFile(storeFilePath);
        FruitStoreDao fruitStoreDao = new FruitStoreDaoImpl();
        fruitStoreDao.addDataToStorage(fileReader);

        // Creating of operation handler Map
        Map<StoreOperation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(StoreOperation.BALANCE, new BalanceOperationHandler());
        handlerMap.put(StoreOperation.SUPPLY, new SupplyOperationHandler());
        handlerMap.put(StoreOperation.PURCHASE, new PurchaseOperationHandler());
        handlerMap.put(StoreOperation.RETURN, new ReturnOperationHandler());

        // Creating an object of StoreOperation Strategy
        StoreOperationStrategy operationStrategy = new StoreOperationStrategyImpl(handlerMap);

        // Creating report list
        ReportService reportService = new ReportServiceImpl();
        String fruitReport = reportService.createReport(operationStrategy);

        // Creating file for writing report
        String reportFilePath = "src/main/resources/friutreportdata.csv";
        CreatingFileService creatingFileReport = new CreatingFileServiceImpl();
        creatingFileReport.createFile(reportFilePath);

        // Writing report data to csv file
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeDataToFile(reportFilePath, fruitReport);
    }
}
