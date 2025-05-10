package main;

import db.FruitsStorage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.OperationType;
import model.OutFileStructure;
import service.FruitShopService;
import service.ParserService;
import service.ReportService;
import service.WriterService;
import service.impl.FruitShopServiceImpl;
import service.impl.ParserServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.impl.BalanceOperationHandlerImpl;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseOperationHandlerImpl;
import strategy.impl.ReturnOperationHandlerImpl;
import strategy.impl.SupplyOperationHandlerImpl;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/activities.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/dailyreport.csv";
    private static final String FIRST_REPORT_COLUMN = "fruit";
    private static final String SECOND_REPORT_COLUMN = "quantity";

    public static void main(String[] arg) {
        ReaderServiceImpl readFromCsvFile = new ReaderServiceImpl();
        List<String> dataFromFile = readFromCsvFile.readFromCsvFile(INPUT_FILE_NAME);

        Map<OperationType, OperationHandler> operationTypeMap = new HashMap<>();

        OperationHandler balanceOperationHandler = new BalanceOperationHandlerImpl();
        OperationHandler purchaseOperationHandler = new PurchaseOperationHandlerImpl();
        OperationHandler supplyOperationHandler = new SupplyOperationHandlerImpl();
        OperationHandler returnOperationHandler = new ReturnOperationHandlerImpl();

        operationTypeMap.put(OperationType.BALANCE, balanceOperationHandler);
        operationTypeMap.put(OperationType.SUPPLY, supplyOperationHandler);
        operationTypeMap.put(OperationType.RETURN, returnOperationHandler);
        operationTypeMap.put(OperationType.PURCHASE, purchaseOperationHandler);

        OperationStrategy operationStrategy =
                new OperationStrategyImpl(operationTypeMap);

        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitsTransactionList = parserService
                .getFruitTransaction(dataFromFile);

        FruitShopService fruitShopService =
                new FruitShopServiceImpl(operationStrategy);
        fruitShopService.getFruitBalance(fruitsTransactionList);

        OutFileStructure outFileStructure =
                new OutFileStructure(FIRST_REPORT_COLUMN, SECOND_REPORT_COLUMN);

        FruitsStorage fruitCurrentStorage = new FruitsStorage();

        ReportService reportService = new ReportServiceImpl();
        String dataReport = reportService.getDataReport(outFileStructure, fruitCurrentStorage);

        WriterService writer = new WriterServiceImpl();
        writer.writeToCsvFile(OUTPUT_FILE_NAME, dataReport);

        System.out.println(fruitCurrentStorage.getFruitsStorage().toString());
    }
}
