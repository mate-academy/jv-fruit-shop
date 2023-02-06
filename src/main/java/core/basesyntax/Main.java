package core.basesyntax;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportCreatorImpl;
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
    private static final String INPUT_FILE_CSV = "src/main/resources/InputFile.csv";
    private static final String OUTPUT_FILE_CSV = "src/main/resources/OutputFile.csv";

    public static void main(String[] args) {
        FileReader dataReader = new FileReaderImpl();
        List<String> transactions = dataReader.readFromFile(INPUT_FILE_CSV);

        BalanceOperationHandler balanceOperationHandler = new BalanceOperationHandler();
        SupplyOperationHandler supplyOperationHandler = new SupplyOperationHandler();
        PurchaseOperationHandler purchaseOperationHandler = new PurchaseOperationHandler();

        provideHandlersMap(balanceOperationHandler, supplyOperationHandler,
                purchaseOperationHandler);

        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransaction =
                transactionParser.parseFruitTransactions(transactions);

        OperationStrategy operationStrategy = new OperationStrategyImpl(provideHandlersMap(
                balanceOperationHandler, supplyOperationHandler, purchaseOperationHandler));

        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        fruitShopService.provideOperation(fruitTransaction);

        ReportCreator reportCreatorService = new ReportCreatorImpl();
        String report = reportCreatorService.createReport(Storage.fruitsQuantity);

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report, OUTPUT_FILE_CSV);
    }

    private static Map<FruitTransaction.Operation, OperationHandler> provideHandlersMap(
            BalanceOperationHandler balanceOperationHandler,
            SupplyOperationHandler supplyOperationHandler,
            PurchaseOperationHandler purchaseOperationHandler) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, balanceOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, supplyOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, purchaseOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, supplyOperationHandler);
        return operationHandlerMap;
    }
}


