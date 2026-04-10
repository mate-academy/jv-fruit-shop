package core;

import core.checker.Checker;
import core.db.InMemoryStorage;
import core.model.Transaction;
import core.service.Converter;
import core.service.Reader;
import core.service.ReportGenerator;
import core.service.ShopService;
import core.service.TransactionDao;
import core.service.Writer;
import core.service.impl.ConverterCsvImpl;
import core.service.impl.CsvReaderImpl;
import core.service.impl.CsvWriterImpl;
import core.service.impl.ReportGeneratorImpl;
import core.service.impl.ShopServiceImpl;
import core.service.impl.TransactionDaoImpl;
import core.strategy.OperationStrategy;
import core.strategy.OperationStrategyImpl;
import core.strategy.handler.BalanceHandler;
import core.strategy.handler.OperationHandler;
import core.strategy.handler.PurchaseHandler;
import core.strategy.handler.ReturnHandler;
import core.strategy.handler.SupplyHandler;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Reader reader = new CsvReaderImpl();
        List<String> lines = reader.readFile("FileInput.csv");

        InMemoryStorage inMemoryStorage = new InMemoryStorage();
        Checker checker = new Checker(inMemoryStorage);

        TransactionDao transactionDao = new TransactionDaoImpl(inMemoryStorage, checker);
        Converter converter = new ConverterCsvImpl(transactionDao);

        List<Transaction> transactions = converter.convertCsvLines(lines);

        OperationHandler balanceHandler = new BalanceHandler(transactionDao);
        OperationHandler supplyHandler = new SupplyHandler(transactionDao);
        OperationHandler returnHandler = new ReturnHandler(transactionDao);
        OperationHandler purchaseHandler = new PurchaseHandler(transactionDao);

        Map<Transaction.Operation, OperationHandler> handlers = Map.of(
                Transaction.Operation.BALANCE, balanceHandler,
                Transaction.Operation.RETURN, returnHandler,
                Transaction.Operation.PURCHASE, purchaseHandler,
                Transaction.Operation.SUPPLY, supplyHandler
        );

        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy, transactionDao);

        shopService.process(transactions);
        Map<String, Integer> processedData = shopService.getData();

        ReportGenerator generator = new ReportGeneratorImpl();
        String report = generator.generateReport(processedData);

        Writer writer = new CsvWriterImpl();
        writer.writeToFile(report, "FileOutput.csv");
    }
}
