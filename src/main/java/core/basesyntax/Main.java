package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.ReportBuilderService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReportBuilderServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandlerImpl;
import core.basesyntax.strategy.operation.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.operation.SupplyOperationHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputFilePath = "src/main/resources/database.csv";
    private static final String reportFilePath = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> strategies = new HashMap<>();
        strategies.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandlerImpl());

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> readData = fileReaderService.read(inputFilePath);

        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
        List<FruitTransaction> fruitTransactionsList = fruitTransactionParser
                .getFruitTransactionsList(readData);

        OperationStrategy operationStrategy = new OperationStrategyImpl(strategies);

        FruitShopService fruitShopService = new FruitShopServiceImpl();
        fruitShopService.processTransactions(fruitTransactionsList,
                operationStrategy);

        ReportBuilderService reportBuilderService = new ReportBuilderServiceImpl();
        String report = reportBuilderService.createReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeDataToFile(report, reportFilePath);
    }
}
