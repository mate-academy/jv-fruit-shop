package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReaderService;
import service.FileWriterService;
import service.FruitShopService;
import service.ReportGenerator;
import service.TransactionParserService;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.FruitShopServiceImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.TransactionParserServiceImpl;
import strategy.OperationHandler;
import strategy.impl.BalanceHandler;
import strategy.impl.OperatorStrategyImpl;
import strategy.impl.PurchaseHandler;
import strategy.impl.ReturnHandler;
import strategy.impl.SupplyHandler;

public class Main {
    private static String inputFilePath = "src/main/resources/input.csv";
    private static String outputFilePath = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> lines = fileReaderService.readFromFile(inputFilePath);
        TransactionParserService fileParserService = new TransactionParserServiceImpl();
        List<FruitTransaction> transactions = fileParserService.parseFileInformation(lines);
        FruitShopService fruitShopService =
                new FruitShopServiceImpl(new OperatorStrategyImpl(operationHandlerMap));
        fruitShopService.startFruitsOperations(transactions);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.createReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report, outputFilePath);
    }
}
