package core.basesyntax;

import core.basesyntax.handler.BalanceOperationHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseOperationHandler;
import core.basesyntax.handler.ReturnOperationHandler;
import core.basesyntax.handler.SupplyOperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceCsvImpl;
import core.basesyntax.service.impl.ReportServiceCsvImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_FILE_PATH = "src/main/resources/monday.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";
    private static final Map<Operation, OperationHandler> OPERATION_HANDLER_MAP = new HashMap<>();

    static {
        OPERATION_HANDLER_MAP.put(Operation.BALANCE, new BalanceOperationHandler());
        OPERATION_HANDLER_MAP.put(Operation.PURCHASE, new PurchaseOperationHandler());
        OPERATION_HANDLER_MAP.put(Operation.SUPPLY, new SupplyOperationHandler());
        OPERATION_HANDLER_MAP.put(Operation.RETURN, new ReturnOperationHandler());
    }

    public static void main(String[] args) {
        final ReaderService readerService = new ReaderServiceCsvImpl();
        List<String> lines = readerService.readFromFile(DATA_FILE_PATH);

        final TransactionService transactionService = new TransactionServiceImpl();
        List<FruitTransaction> transactions = transactionService.parseTransactions(lines);

        final FruitService fruitService = new FruitServiceImpl(OPERATION_HANDLER_MAP);
        fruitService.manageTransactions(transactions);

        final ReportService reportService = new ReportServiceCsvImpl();
        String report = reportService.createReport();

        final WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(REPORT_FILE_PATH, report);
    }
}
