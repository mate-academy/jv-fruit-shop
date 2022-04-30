package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.LineParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderFileServiceImpl;
import core.basesyntax.service.impl.FileWriterFileServiceImpl;
import core.basesyntax.service.impl.FruitTransactionImpl;
import core.basesyntax.service.impl.FruitTransactionImpl.Operation;
import core.basesyntax.service.impl.LineParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.FruitOperation;
import core.basesyntax.strategy.imp.BalanceFruitOperation;
import core.basesyntax.strategy.imp.PurchaseFruitOperation;
import core.basesyntax.strategy.imp.ReturnFruitOperation;
import core.basesyntax.strategy.imp.SupplyFruitOperation;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_INITIAL = "src/main/resources/before.csv";
    private static final String FILE_PATH_RESULT = "src/main/resources/result.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<Operation, FruitOperation> transactionMap = new HashMap<>();
        transactionMap.put(Operation.BALANCE, new BalanceFruitOperation(storageDao));
        transactionMap.put(Operation.PURCHASE, new PurchaseFruitOperation(storageDao));
        transactionMap.put(Operation.RETURN, new ReturnFruitOperation(storageDao));
        transactionMap.put(Operation.SUPPLY, new SupplyFruitOperation(storageDao));
        FileReaderService fileReaderService = new FileReaderFileServiceImpl();
        LineParserService lineParserService = new LineParserServiceImpl();
        FruitTransactionImpl fruitTransactionImpl = new FruitTransactionImpl(transactionMap);
        fruitTransactionImpl
                .doTransaction(lineParserService.parseDate(
                        fileReaderService.read(FILE_PATH_INITIAL)));
        ReportService reportService = new ReportServiceImpl(storageDao);
        String report = reportService.createReport();
        FileWriterService fileWriterService = new FileWriterFileServiceImpl();
        fileWriterService.write(FILE_PATH_RESULT, report);
    }
}
