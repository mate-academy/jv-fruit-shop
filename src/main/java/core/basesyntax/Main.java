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
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceCsvImpl;
import core.basesyntax.service.impl.ReportServiceCsvImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Operation, OperationHandler> OPERATION_HANDLER_MAP = new HashMap<>();

    static {
        OPERATION_HANDLER_MAP.put(Operation.BALANCE, new BalanceOperationHandler());
        OPERATION_HANDLER_MAP.put(Operation.PURCHASE, new PurchaseOperationHandler());
        OPERATION_HANDLER_MAP.put(Operation.SUPPLY, new SupplyOperationHandler());
        OPERATION_HANDLER_MAP.put(Operation.RETURN, new ReturnOperationHandler());
    }

    public static void main(String[] args) {
        String dataFilePath = "src/main/resources/monday.csv";
        String reportFilePath = "src/main/resources/report.csv";

        final ReaderService readerService = new ReaderServiceCsvImpl();
        List<FruitTransaction> transactions = readerService.readFromFile(dataFilePath);

        final FruitService fruitService = new FruitServiceImpl(OPERATION_HANDLER_MAP);
        fruitService.manageTransactions(transactions);

        final ReportService reportService = new ReportServiceCsvImpl();
        String report = reportService.createReport();

        final WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(reportFilePath, report);
    }
}
