package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.service.GeneratorReportService;
import core.basesyntax.service.ParserDataService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitTransactionImpl;
import core.basesyntax.service.impl.FruitTransactionImpl.Operation;
import core.basesyntax.service.impl.GeneratorReportServiceImpl;
import core.basesyntax.service.impl.ParserDataServiceImpl;
import core.basesyntax.service.impl.ReaderFileServiceImpl;
import core.basesyntax.service.impl.WriterFileServiceImpl;
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
        ReaderService readerService = new ReaderFileServiceImpl();
        ParserDataService parserDataService = new ParserDataServiceImpl();
        FruitTransactionImpl fruitTransactionImpl = new FruitTransactionImpl(transactionMap);
        fruitTransactionImpl
                .doTransaction(parserDataService.parseDate(readerService.read(FILE_PATH_INITIAL)));
        GeneratorReportService generatorReportService = new GeneratorReportServiceImpl(storageDao);
        String report = generatorReportService.createReport();
        WriterService writerService = new WriterFileServiceImpl();
        writerService.write(FILE_PATH_RESULT, report);
    }
}
