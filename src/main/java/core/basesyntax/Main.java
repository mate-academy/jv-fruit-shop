package core.basesyntax;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dao.StorageDaoImp;
import core.basesyntax.model.GoodsOperation;
import core.basesyntax.service.CsvParseService;
import core.basesyntax.service.FileReadService;
import core.basesyntax.service.FileWriteService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.imp.CsvParser;
import core.basesyntax.service.imp.FileReadServiceImp;
import core.basesyntax.service.imp.FileWriteServiceImp;
import core.basesyntax.service.imp.Reporter;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationsStrategy;
import core.basesyntax.strategy.handlers.BalanceOperationHandler;
import core.basesyntax.strategy.handlers.PurchaseOperationHandler;
import core.basesyntax.strategy.handlers.ReturnOperationHandler;
import core.basesyntax.strategy.handlers.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String NAME_SOURCE_FILE = "SourceFile.txt";
    private static final String PATH_SOURCE_FILE = "src/main/resources/" + NAME_SOURCE_FILE;
    private static final String NAME_CONSUMER_FILE = "ConsumerFile.txt";
    private static final String PATH_CONSUMER_FILE = "src/main/resources/" + NAME_CONSUMER_FILE;
    private static final Map<String, Integer> storage;
    private static final FileReadService fileReadService;
    private static final CsvParseService csvParseService;
    private static final Map<GoodsOperation.TransactionType, OperationHandler> strategies;
    private static final StorageDao storageDao;
    private static final OperationsStrategy operationsStrategy;
    private static final ReportService reportService;
    private static final FileWriteService fileWriteService;

    static {
        storage = new HashMap<>();
        storageDao = new StorageDaoImp(storage);
        fileReadService = new FileReadServiceImp();
        csvParseService = new CsvParser();
        strategies = Map.of(GoodsOperation.TransactionType.BALANCE,
                new BalanceOperationHandler(storageDao),
                GoodsOperation.TransactionType.PURCHASE,
                new PurchaseOperationHandler(storageDao),
                GoodsOperation.TransactionType.RETURN,
                new ReturnOperationHandler(storageDao),
                GoodsOperation.TransactionType.SUPPLY,
                new SupplyOperationHandler(storageDao));
        operationsStrategy = new OperationsStrategy(strategies);
        reportService = new Reporter(storageDao);
        fileWriteService = new FileWriteServiceImp();
    }

    public static void main(String[] args) {
        List<String> parsedLines = fileReadService.readFilesLines(PATH_SOURCE_FILE);
        List<GoodsOperation> operationsList = csvParseService
                .listOperationsFromCsv(parsedLines);
        for (GoodsOperation operation : operationsList) {
            operationsStrategy.handleOperation(operation);
        }
        List<String> goodsStockCsvReport = reportService.getGoodsStockCsv();
        fileWriteService.writeCvsToFile(goodsStockCsvReport, PATH_CONSUMER_FILE);
    }
}
