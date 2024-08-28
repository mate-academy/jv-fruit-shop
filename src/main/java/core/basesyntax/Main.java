package core.basesyntax;

import core.basesyntax.dao.TransactionParser;
import core.basesyntax.dao.TransactionParserImpl;
import core.basesyntax.handler.BalanceOperationHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseOperationHandler;
import core.basesyntax.handler.ReturnOperationHandler;
import core.basesyntax.handler.SupplyOperationHandler;
import core.basesyntax.io.FileReader;
import core.basesyntax.io.FileReaderImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.report.CsvReportWriterImpl;
import core.basesyntax.report.ReportBuilder;
import core.basesyntax.report.ReportBuilderImpl;
import core.basesyntax.report.ReportWriter;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.storage.FruitStorage;
import core.basesyntax.storage.FruitStorageImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TransactionParser transactionParser = new TransactionParserImpl();
        String filePath = "src/main/resources/file.csv";

        FruitStorage fruitStorage = new FruitStorageImpl();

        OperationHandler balanceHandler = new BalanceOperationHandler(fruitStorage);
        OperationHandler supplyHandler = new SupplyOperationHandler(fruitStorage);
        OperationHandler returnHandler = new ReturnOperationHandler(fruitStorage);
        OperationHandler purchaseHandler = new PurchaseOperationHandler(fruitStorage);

        //Creating Map with Transactions operations as KEY and Handlers as VALUE

        Map<FruitTransaction.Operation, OperationHandler> handlers = Map.of(
                FruitTransaction.Operation.BALANCE,
                balanceHandler,
                FruitTransaction.Operation.SUPPLY,
                supplyHandler,
                FruitTransaction.Operation.PURCHASE,
                purchaseHandler,
                FruitTransaction.Operation.RETURN,
                returnHandler);

        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);

        FileReader fileReader = new FileReaderImpl();
        List<String> transactionsList = fileReader.readFile(filePath);

        List<FruitTransaction> transactions = transactionParser.parseTransactions(transactionsList);
        ShopService shopService = new ShopServiceImpl(operationStrategy, fruitStorage);
        shopService.processTransactions(transactions);

        ReportBuilder reportBuilder = new ReportBuilderImpl();
        String reportData = reportBuilder.buildReport(fruitStorage);

        String reportPath = "src/main/resources/report.csv";
        ReportWriter reportWriter = new CsvReportWriterImpl();
        reportWriter.writeReport(reportData, reportPath);
    }
}
