package main;

import db.FruitsStorage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.OperationType;
import model.OutFileStructure;
import service.FileParser;
import service.FruitDalyTransactionsHandler;
import service.ReportService;
import service.WriteToFile;
import service.impl.FileParserImpl;
import service.impl.FruitDalyTransactionsHandlerImpl;
import service.impl.ReadFromCsvFileImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriteToCsvFileImpl;
import service.operation.handlers.BalanceOperationHandlerImpl;
import service.operation.handlers.OperationHandler;
import service.operation.handlers.PurchaseOperationHandlerImpl;
import service.operation.handlers.ReturnOperationHandlerImpl;
import service.operation.handlers.SupplyOperationHandlerImpl;
import strategy.DalyOperationStrategy;
import strategy.DalyOperationStrategyImpl;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/activities.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/dailyreport.csv";
    private static final String FIRST_REPORT_COLUMN = "fruit";
    private static final String SECOND_REPORT_COLUMN = "quantity";

    public static void main(String[] arg) {
        ReadFromCsvFileImpl readFromCsvFile = new ReadFromCsvFileImpl();
        List<String> dataFromFile = readFromCsvFile.readFromCsvFile(INPUT_FILE_NAME);

        FileParser fileParser = new FileParserImpl();
        List<FruitTransaction> fruitsTransactionList =
                fileParser.getFruitTransaction(dataFromFile);

        Map<OperationType, OperationHandler> operationTypeMap = new HashMap<>();
        OperationHandler balanceOperationHandler = new BalanceOperationHandlerImpl();
        OperationHandler purchaseOperationHandler = new PurchaseOperationHandlerImpl();
        OperationHandler supplyOperationHandler = new SupplyOperationHandlerImpl();
        OperationHandler returnOperationHandler = new ReturnOperationHandlerImpl();

        operationTypeMap.put(OperationType.BALANCE, balanceOperationHandler);
        operationTypeMap.put(OperationType.SUPPLY, supplyOperationHandler);
        operationTypeMap.put(OperationType.RETURN, returnOperationHandler);
        operationTypeMap.put(OperationType.PURCHASE, purchaseOperationHandler);

        DalyOperationStrategy dalyOperationStrategy =
                new DalyOperationStrategyImpl(operationTypeMap);

        FruitDalyTransactionsHandler fruitDalyTransactionsHandler =
                new FruitDalyTransactionsHandlerImpl();
        FruitsStorage fruitCurrentStorage =
                fruitDalyTransactionsHandler.getFruitBalance(fruitsTransactionList,
                        dalyOperationStrategy);

        OutFileStructure outFileStructure =
                new OutFileStructure(FIRST_REPORT_COLUMN, SECOND_REPORT_COLUMN);

        ReportService reportService = new ReportServiceImpl();
        String dataReport = reportService.getDataReport(outFileStructure, fruitCurrentStorage);

        WriteToFile writer = new WriteToCsvFileImpl();
        writer.writeToCsvFile(OUTPUT_FILE_NAME, dataReport);

        System.out.println(fruitCurrentStorage.getFruitsStorage().toString());
    }
}
