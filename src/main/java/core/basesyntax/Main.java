package core.basesyntax;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderImpl;
import core.basesyntax.service.CsvFileWriterImpl;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.ReportCreatorServiceImpl;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionParserImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handlers.BalanceOperationHandler;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.PurchaseOperationHandler;
import core.basesyntax.strategy.handlers.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/InputFile.csv";
        FileReader dataReader = new CsvFileReaderImpl();
        List<String> transactions = dataReader.readFromFile(inputFilePath);

        BalanceOperationHandler balanceOperationHandler = new BalanceOperationHandler();
        SupplyOperationHandler supplyOperationHandler = new SupplyOperationHandler();
        PurchaseOperationHandler purchaseOperationHandler = new PurchaseOperationHandler();

        TransactionParser transactionParser = new TransactionParserImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, balanceOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, supplyOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, purchaseOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, supplyOperationHandler);

        List<FruitTransaction> fruitTransaction =
                transactionParser.getFruitTransaction(transactions);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        fruitShopService.operationProvider(fruitTransaction);

        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        String report = reportCreatorService.createReport(Storage.fruitsQuantity);

        String outputFilePath = "src/main/resources/OutputFile.csv";
        FileWriter fileWriter = new CsvFileWriterImpl();
        fileWriter.writeToFile(report, outputFilePath);
    }
}


