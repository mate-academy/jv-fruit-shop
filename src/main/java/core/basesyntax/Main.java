package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StrategyApplierService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReaderService;
import core.basesyntax.service.impl.CsvWriterService;
import core.basesyntax.service.impl.FruitMapperImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StrategyApplierServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    public static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        CsvReaderService csvReaderService = new CsvReaderService();
        List<String> lines = csvReaderService.readFromFile(INPUT_FILE_PATH);
        FruitMapperImpl fruitMapper = new FruitMapperImpl();
        List<FruitTransaction> fruitTransactions = fruitMapper.mapData(lines);
        StorageDao storageDao = new StorageDaoImpl();
        Map<Operation, OperationHandler> handlers = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(storageDao),
                Operation.RETURN, new ReturnOperationHandler(storageDao),
                Operation.PURCHASE, new PurchaseOperationHandler(storageDao),
                Operation.SUPPLY, new SupplyOperationHandler(storageDao)
        );
        OperationStrategy strategy = new OperationStrategy(handlers);
        StrategyApplierService strategyApplier = new StrategyApplierServiceImpl();
        strategyApplier.applyMethod(fruitTransactions, strategy);
        ReportService report = new ReportServiceImpl();
        String reportString = report.generateReport(Storage.storage);
        WriterService writer = new CsvWriterService();
        writer.write(REPORT_FILE_PATH,reportString);
    }
}
