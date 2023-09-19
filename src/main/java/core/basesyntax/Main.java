package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.model.handler.OperationHandler;
import core.basesyntax.model.handler.impl.BalanceOperationHandler;
import core.basesyntax.model.handler.impl.PurchaseOperationHandler;
import core.basesyntax.model.handler.impl.ReturnOperationHandler;
import core.basesyntax.model.handler.impl.SupplyOperationHandler;
import core.basesyntax.model.service.OperatorService;
import core.basesyntax.model.service.ParserService;
import core.basesyntax.model.service.ReaderService;
import core.basesyntax.model.service.ReportService;
import core.basesyntax.model.service.WriterService;
import core.basesyntax.model.service.impl.OperatorServiceImpl;
import core.basesyntax.model.service.impl.ParserServiceImpl;
import core.basesyntax.model.service.impl.ReaderServiceImpl;
import core.basesyntax.model.service.impl.ReportServiceImpl;
import core.basesyntax.model.service.impl.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_FILE_PATH = "src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";
    private static final FruitStorageDao FRUIT_STORAGE_DAO = new FruitStorageDaoImpl();
    private static final Map<Operation, OperationHandler> OPERATION_MAP = new HashMap<>();

    static {
        OPERATION_MAP.put(Operation.BALANCE, new BalanceOperationHandler(FRUIT_STORAGE_DAO));
        OPERATION_MAP.put(Operation.PURCHASE, new PurchaseOperationHandler(FRUIT_STORAGE_DAO));
        OPERATION_MAP.put(Operation.SUPPLY, new SupplyOperationHandler(FRUIT_STORAGE_DAO));
        OPERATION_MAP.put(Operation.RETURN, new ReturnOperationHandler(FRUIT_STORAGE_DAO));
    }

    public static void main(String[] args) {
        final ReaderService readerService = new ReaderServiceImpl();
        List<String> lines = readerService.readFile(DATA_FILE_PATH);

        final ParserService transactionService = new ParserServiceImpl();
        List<FruitTransaction> transactions = transactionService.parseTransaction(lines);

        final OperatorService fruitService = new OperatorServiceImpl(OPERATION_MAP);
        fruitService.operateTransactions(transactions);

        final ReportService reportService = new ReportServiceImpl(FRUIT_STORAGE_DAO);
        String report = reportService.createReport();

        final WriterService writerService = new WriterServiceImpl();
        writerService.writeReport(REPORT_FILE_PATH, report);
    }
}
