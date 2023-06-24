package core.basesyntax;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.db.impl.ProductStorageImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.impl.BalanceOperationHandler;
import core.basesyntax.operation.impl.PurchaseOperationHandler;
import core.basesyntax.operation.impl.ReturnOperationHandler;
import core.basesyntax.operation.impl.SupplyOperationHandler;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT = "src/main/resources/input.csv";
    private static final String OUTPUT = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ProductStorage productStorage = new ProductStorageImpl();
        TransactionService transactionService =
                new TransactionServiceImpl(createOperationHandlerMap(productStorage));
        ReaderService readerService = new ReaderServiceImpl();
        String data = readerService.readFromFile(INPUT);
        Parser parser = new CsvParserImpl();
        List<Transaction> transactions = parser.parse(data);
        transactionService.executeTransactions(transactions);
        ReportService reportService = new ReportServiceImpl(productStorage);
        String report = reportService.generateReport();
        WriterService writerService = new WriteServiceImpl();
        writerService.writeToFile(OUTPUT, report);
    }

    private static Map<Operation, OperationHandler> createOperationHandlerMap(
            ProductStorage productStorage) {
        Map<Operation, OperationHandler> map = new HashMap<>();
        map.put(Operation.BALANCE, new BalanceOperationHandler(productStorage));
        map.put(Operation.PURCHASE, new PurchaseOperationHandler(productStorage));
        map.put(Operation.RETURN, new ReturnOperationHandler(productStorage));
        map.put(Operation.SUPPLY, new SupplyOperationHandler(productStorage));
        return map;
    }
}
