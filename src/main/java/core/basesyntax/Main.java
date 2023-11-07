package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.handler.BalanceOperationHandler;
import core.basesyntax.operation.handler.PurchaseOperationHandler;
import core.basesyntax.operation.handler.ReturnOperationHandler;
import core.basesyntax.operation.handler.SupplyOperationHandler;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.QuantityCalculatorService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.QuantityCalculatorServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final FruitStorageDao FRUIT_STORAGE_DAO = new FruitStorageDaoImpl();
    private static final String FILE_TRANSACTIONS_PATH = "src/main/resources/transactions.csv";
    private static final String FILE_REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(Operation.BALANCE, new BalanceOperationHandler(FRUIT_STORAGE_DAO));
        operationMap.put(Operation.RETURN, new ReturnOperationHandler(FRUIT_STORAGE_DAO));
        operationMap.put(Operation.SUPPLY, new SupplyOperationHandler(FRUIT_STORAGE_DAO));
        operationMap.put(Operation.PURCHASE, new PurchaseOperationHandler(FRUIT_STORAGE_DAO));

        ReaderService readerService = new ReaderServiceImpl();
        List<String> lines = readerService.readFile(FILE_TRANSACTIONS_PATH);

        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parseFruitTransactions(lines);

        QuantityCalculatorService quantityCalculatorService
                = new QuantityCalculatorServiceImpl(operationMap);
        quantityCalculatorService.calcualteQuantityForFruits(fruitTransactions);

        ReportService reportService = new ReportServiceImpl(FRUIT_STORAGE_DAO);
        String report = reportService.generateReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeReport(FILE_REPORT_PATH, report);
    }
}
